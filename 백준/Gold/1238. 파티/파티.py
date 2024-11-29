import heapq
import math
    
def dijkstra(node) :
    S = set()
    Q = []
    d = [math.inf] * (N + 1)
    d[node] = 0

    heapq.heappush(Q, (0, node))

    while Q :
        w, u = heapq.heappop(Q)

        if u in S :
            continue

        S.add(u)

        for v, w_uv in neighbors[u] :
            if v not in S and d[u] + w_uv < d[v] :
                d[v] = d[u] + w_uv
                heapq.heappush(Q, (d[v], v))

    return d

N, M, X = map(int, input().split())

neighbors = [[] for _ in range(N + 1)]

for _ in range(M) :
    u, v, w = map(int, input().split())
    neighbors[u].append((v, w))


# X에서부터 각 정점까지의 최소비용 거리
arr = dijkstra(X)

arr[0] = 0 # max 구할 때 node 0은 제외해야 하므로

# 각 정점에서 X까지의 거리를 더해 왕복 최소 비용 구하기
for i in range(1, N + 1) :
    tmp = dijkstra(i)
    arr[i] += tmp[X]

print(max(arr))