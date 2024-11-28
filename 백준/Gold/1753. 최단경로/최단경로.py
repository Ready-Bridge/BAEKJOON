import heapq
import math

V, E = map(int, input().split())
k = int(input())

prev = [-1] * (V + 1)
d = [math.inf] * (V + 1)
d[k] = 0
S = set()
neightbors = [[] for _ in range(V + 1)]
Q = []
heapq.heappush(Q, (0, k))

for i in range(E) :
    u, v, w = map(int, input().split())
    neightbors[u].append((v, w))

while Q :
    w, u = heapq.heappop(Q)

    if u in S :
        continue

    S.add(u)

    for v, w_uv in neightbors[u] :
        if v not in S and d[u] + w_uv < d[v] :
            d[v] = d[u] + w_uv
            prev[v] = u
            heapq.heappush(Q, (d[v], v))


for i in range(1, V + 1) :
    if d[i] == math.inf :
        print("INF")
    
    else :
        print(d[i])