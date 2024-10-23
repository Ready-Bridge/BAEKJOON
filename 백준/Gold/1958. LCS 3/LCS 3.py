a = input()
b = input()
c = input()

x = len(a)
y = len(b)
z = len(c)

dp = [[[0] * (z + 1) for _ in range(y + 1)] for _ in range(x + 1)]

for ai in range(x) :
    for bi in range(y) :
        for ci in range(z) :

            if a[ai] == b[bi] == c[ci] :
                dp[ai][bi][ci] = dp[ai - 1][bi - 1][ci - 1] + 1
            
            else :
                dp[ai][bi][ci] = max(dp[ai - 1][bi][ci], dp[ai][bi - 1][ci], dp[ai][bi][ci - 1])
    
print(dp[x - 1][y - 1][z - 1])