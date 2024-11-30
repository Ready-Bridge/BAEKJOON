import sys
import math

N, M = map(int, sys.stdin.readline().split())

E = []

for _ in range(M) :
    u, v, w = map(int, sys.stdin.readline().split())
    E.append((u, v, w))

def bellman() :

    d = [math.inf] * (N + 1)
    d[1] = 0 # 1번 도시에서 시작하므로 weight 0으로

    # |V| - 1 번 반복
    for _ in range(1, N) :
        for (u, v, w_uv) in E :
            if d[u] + w_uv < d[v] :
                d[v] = d[u] + w_uv

    # 음의 사이클 확인
    for (u, v, w_uv) in E :
        if d[u] + w_uv < d[v] :
            print(-1)
            return

    # 도달 못하는 inf 들 -1로 변경
    for i in range(2, N + 1) :
        if d[i] == math.inf :
            d[i] = -1

    for i in range(2, N + 1) :
        print(d[i])
    
    
bellman()