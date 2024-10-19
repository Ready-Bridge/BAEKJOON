import sys

x = sys.stdin.readline().strip()
y = sys.stdin.readline().strip()

m = len(x)
n = len(y)

dp = [[""] * (n + 1) for _ in range(m + 1)]

for i in range(m) :
    for k in range(n) :

        if x[i] == y[k] :
            dp[i][k] = dp[i - 1][k - 1] + x[i]
        
        else :

            if len(dp[i - 1][k]) >= len(dp[i][k - 1]) :
                dp[i][k] = dp[i - 1][k]
            
            else :
                dp[i][k] = dp[i][k - 1]


print(len(dp[m - 1][n - 1]))

if len(dp[m - 1][n - 1]) > 0 :
    print(dp[m - 1][n - 1])