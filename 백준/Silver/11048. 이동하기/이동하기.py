N, M = map(int, input().split())

arr = []
dp = [[0] * (M + 1) for _ in range(N + 1)]

for i in range(N) :
    arr.append(list(map(int , input().split())))

for i in range(N) :
    for k in range(M) :
        dp[i][k] = max(dp[i - 1][k], dp[i][k - 1], dp[i - 1][k - 1]) + arr[i][k]

print(dp[N - 1][M - 1])