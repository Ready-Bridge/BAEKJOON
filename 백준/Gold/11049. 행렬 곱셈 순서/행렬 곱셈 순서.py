import sys
import math

N = int(sys.stdin.readline())

arr = []

for i in range(N) :
    a, b = map(int, sys.stdin.readline().split())
    arr.append(a)

arr.append(b)

n = len(arr)

dp = [[math.inf] * n for _ in range(n)]

for i in range(n - 1) :
    dp[i][i + 1] = 0

# 곱하는걸 2개곱했을 때, 3개곱했을 때, ... 으로 늘려나감

for i in range(2, n) : # 몇개씩 확인할건지
    for s in range(n - i) : # 시작점
        e = s + i
        for j in range(s + 1, e) :
            dp[s][e] = min(dp[s][e], dp[s][j] + dp[j][e] + arr[s] * arr[j] * arr[e])

print(dp[0][n - 1])