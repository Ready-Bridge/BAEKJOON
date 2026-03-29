SELECT 
    A.APNT_NO, 
    P.PT_NAME, 
    P.PT_NO, 
    D.MCDP_CD, 
    D.DR_NAME, 
    A.APNT_YMD -- 포맷팅 없이 혹은 초 단위까지만 포맷팅
FROM APPOINTMENT A
JOIN PATIENT P ON A.PT_NO = P.PT_NO
JOIN DOCTOR D ON A.MDDR_ID = D.DR_ID
WHERE 
    A.APNT_YMD LIKE '2022-04-13%' -- 날짜 조건
    AND A.MCDP_CD = 'CS'          -- 진료과 코드 (A 또는 D 둘 다 가능)
    AND A.APNT_CNCL_YN = 'N'      -- 취소되지 않은 예약
ORDER BY A.APNT_YMD ASC;          -- 6번째 컬럼 기준 정렬