a = input()
b = input()

x = len(a)
y = len(b)

dp = [[0] * (y + 1) for _ in range(x + 1)]


for i in range(x) :
    for k in range(y) :

        if a[i] == b[k] :
            dp[i][k] = dp[i - 1][k - 1] + 1
        
        else :
            dp[i][k] = max(dp[i - 1][k], dp[i][k - 1])
    

print(dp[x - 1][y - 1])