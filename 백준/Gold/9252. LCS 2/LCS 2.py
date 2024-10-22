a = input()
b = input()

x, y = len(a), len(b)

dp = [[0] * (y + 1) for _ in range(x + 1)]

for i in range(x) :
    for k in range(y) :
        
        if a[i] == b[k] :
            dp[i][k] = dp[i - 1][k - 1] + 1
        
        else :
            dp[i][k] = max(dp[i - 1][k], dp[i][k - 1])
    

print(dp[x - 1][y - 1])

result = []

while x > 0 and y > 0 :

    if a[x - 1] == b[y - 1] : 
        result.append(a[x - 1])

        x -= 1
        y -= 1
    
    else :

        if dp[x - 2][y - 1] >= dp[x - 1][y - 2] :
            
            x -= 1
        
        else :
            
            y -= 1

print("".join(result)[::-1])