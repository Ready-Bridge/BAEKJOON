T = int(input())

for _ in range(T) :

    N = int(input())

    ans = 0
    arr = list(map(int, input().split()))
    prev = arr[N - 1]
    
    # 뒤에서 부터(제일 미래의 주식 가격 부터) 탐색 

    for i in range(N - 2, -1, -1) :

        if arr[i] > prev :

            prev = arr[i]
        
        else :
            
            ans += (prev - arr[i])
    
    print(ans)