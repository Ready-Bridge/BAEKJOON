import math
import heapq

n = int(input())

node = dict() # 좌표 저장
mst = []
Q = []
S = set()
neighbors = [[0 for i in range(n)] for i in range(n)]


for i in range(n) :
    x, y = map(float, input().split())
    node[i] = (x, y)

# 모든 연결 관계를 구해서 neighbors에 저장
for i in range(n):
    for k in range(n) :
        w = round(math.sqrt((node[i][1] - node[k][1]) ** 2 + (node[i][0] - node[k][0]) ** 2), 2)
        neighbors[i][k] = w

heapq.heappush(Q, (0, 0, None)) # weight, node, MST에 연결된 노드

while Q :
    w, u, p = heapq.heappop(Q)

    if u in S :
        continue
    
    S.add(u)
    mst.append(w) # 가중치만 넣음

    for v, w_uv in enumerate(neighbors[u]) :
        if v not in S :
            heapq.heappush(Q, (w_uv, v, u))

print(sum(mst))