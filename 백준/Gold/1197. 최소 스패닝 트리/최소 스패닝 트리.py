# 프림

import heapq

V, E = map(int, input().split())

mst = []
Q = [] # min-heap (후보 간선 관리)
S = set()
neighbors = [[] for _ in range(V + 1)] 
# heap에 시작 노드 넣기
heapq.heappush(Q, (0, 1, None)) # weight, node, MST안의 연결된 node

for _ in range(E) :
    u, v, w = map(int, input().split())
    
    neighbors[u].append((v, w))
    neighbors[v].append((u, w))

while Q :
    w, u, v = heapq.heappop(Q)

    # 이미 u가 MST안에 들어갔다는 뜻
    if u in S :
        continue

    S.add(u)
    mst.append((v, u, w))

    for v, w_uv in neighbors[u] :

        if v not in S :
            heapq.heappush(Q, (w_uv, v, u))


cnt = 0 

for i in mst :
    cnt += i[2]

print(cnt)