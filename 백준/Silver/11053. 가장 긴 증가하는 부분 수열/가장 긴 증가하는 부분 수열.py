n = int(input())
arr = list(map(int, input().split()))

dp = [1] * n

for i in range(1, n) :
    for k in range(i):
        
        if arr[i] > arr[k] :
            dp[i] = max(dp[i], dp[k] + 1)

print(max(dp))