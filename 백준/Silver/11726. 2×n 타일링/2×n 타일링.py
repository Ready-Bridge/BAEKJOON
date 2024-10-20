n = int(input())

dp = [0] * 1001

dp[1] = 1
dp[2] = 2

def S(i) :
    
    if dp[i] != 0 :
        return dp[i]
    
    dp[i] = S(i - 1) + S(i - 2)

    return dp[i]

print(S(n) % 10007)