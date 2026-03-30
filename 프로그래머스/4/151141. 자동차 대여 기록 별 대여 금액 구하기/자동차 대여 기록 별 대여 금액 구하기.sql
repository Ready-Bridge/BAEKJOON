-- 1. 대여 기록별로 '대여 일수'와 '할인 기준 문자열'을 미리 계산해 둔 가상 테이블 생성
WITH RENTAL_INFO AS (
    SELECT
        H.HISTORY_ID,
        C.DAILY_FEE,
        (DATEDIFF(H.END_DATE, H.START_DATE) + 1) AS RENT_DAYS,
        CASE
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN '7일 이상'
            ELSE NULL -- 7일 미만은 할인이 없으므로 NULL
        END AS DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    JOIN CAR_RENTAL_COMPANY_CAR C ON H.CAR_ID = C.CAR_ID
    WHERE C.CAR_TYPE = '트럭' -- 트럭 조건 필수
)

-- 2. 만들어둔 가상 테이블과 할인 플랜 테이블을 조인하여 최종 요금 계산
SELECT
    R.HISTORY_ID,
    -- 요금 계산 로직: 일일대여료 * 대여일수 * (100 - 할인율) / 100
    -- IFNULL을 써서 할인이 없는(NULL) 경우 0% 할인으로 처리하고 FLOOR로 소수점 버림
    FLOOR(R.DAILY_FEE * R.RENT_DAYS * (100 - COALESCE(P.DISCOUNT_RATE, 0)) / 100) AS FEE
FROM RENTAL_INFO R
-- DURATION_TYPE 문자열이 일치하는 것끼리 매칭 (7일 미만은 NULL이므로 조인 안 됨)
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
    ON P.CAR_TYPE = '트럭' AND R.DURATION_TYPE = P.DURATION_TYPE
ORDER BY
    FEE DESC,
    R.HISTORY_ID DESC;