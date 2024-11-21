t = int(input())

for _ in range(t) :

    cnt = 0
    compare = 100001

    rank = [] #순위

    n = int(input()) # 지원자 수
    

    for i in range(n) :
        a, b = map(int, input().split())

        rank.append((a, b))
    
    rank.sort(key = lambda x : x[0])

    # 서류심사를 오름차순하여 순위별로 정렬하였으면
    # 면접 성적이 이전에 나온 가장 높은 순위보다 낮으면 절대 뽑힐 수 없음

    for x in rank :
        if compare >= x[1] :
            compare = x[1]
            cnt += 1
    
    print(cnt)