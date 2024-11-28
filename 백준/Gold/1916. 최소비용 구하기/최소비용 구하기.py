import heapq
import math
from collections import defaultdict

n = int(input())
m = int(input())

neighbors = defaultdict(set)

for i in range(m) :
    u, v, w = map(int, input().split())
    neighbors[u].add((v, w))

start, end = map(int, input().split())

prev = [-1] * (n + 1)
d = [math.inf] * (n + 1)
d[start] = 0
S = set()

Q = []
heapq.heappush(Q,(0, start))

while Q :
    w, u = heapq.heappop(Q)

    if u in S :
        continue

    S.add(u)

    for v, w_uv in neighbors[u] :
        if v not in S and d[u] + w_uv < d[v] :
            d[v] = d[u] + w_uv
            prev[v] = u
            heapq.heappush(Q, (d[v], v))

print(d[end])