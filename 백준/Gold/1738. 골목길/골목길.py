import sys
import math

n, m = map(int, sys.stdin.readline().split())

prev = [-1] * (n + 1)
d = [-math.inf] * (n + 1)
d[1] = 0
E = []
circle = set()

for _ in range(m) :
    u, v, w = map(int, sys.stdin.readline().split())
    E.append((u, v, w))

for _ in range(n - 1) :
    for (u, v, w_uv) in E :
        if d[u] + w_uv > d[v] : # 최대를 구해보자
            d[v] = d[u] + w_uv
            prev[v] = u

for (u, v, w_uv) in E :
    if d[u] + w_uv > d[v] : 
        d[v] = math.inf
            

result = []

if d[n] == math.inf :
    print(-1)

else :
    while(True) :
        if n == 1 :
            result.append(n)
            break
        
        result.append(n)
        n = prev[n]

    for i in range(len(result) - 1, -1, -1) :
        print(result[i], end = " ")