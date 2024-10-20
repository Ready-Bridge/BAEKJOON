n = int(input())

arr = []

for i in range(n) :
    arr.append(int(input()))

dp = [-1] * n

def S() :
    if n == 0 :
        return 0

    elif n == 1:
        return arr[0]
    elif n == 2:
        return arr[0] + arr[1]
    else:
        dp[0] = arr[0]
        dp[1] = arr[0] + arr[1]
        dp[2] = max(arr[0] + arr[2], arr[1] + arr[2])


    for i in range(3, n) :
        dp[i] = max(arr[i] + arr[i - 1] + dp[i - 3], arr[i] + dp[i - 2])


    return dp[n - 1]

print(S())