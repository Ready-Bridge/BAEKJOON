import sys

X = sys.stdin.readline().strip()
Y = sys.stdin.readline().strip()

m, n = len(X), len(Y)

dp = [[0] * (n + 1) for _ in range(m + 1)]

for i in range(m) :
    for k in range(n) :
        
        if X[i] == Y[k] :
            dp[i][k] = dp[i - 1][k - 1] + 1
        
        else :
            dp[i][k] = max(dp[i - 1][k] , dp[i][k - 1])
    

print(dp[m - 1][n - 1])