import sys
import math

N = int(sys.stdin.readline())

arr = []

for i in range(N - 1) :
    a, b = map(int, sys.stdin.readline().split())
    arr.append(a)

a, b = map(int, sys.stdin.readline().split())
arr.append(a)
arr.append(b)

n = len(arr)
dp = [[math.inf] * n for _ in range(n)]

for i in range(n - 1) :
    dp[i][i + 1] = 0


for r in range(2, n) :
    for s in range(n - r) :
        e = s + r
        for i in range(s + 1, e) :
            dp[s][e] = min(dp[s][e], dp[s][i] + dp[i][e] + arr[s] * arr[i] * arr[e])


print(dp[0][n - 1])