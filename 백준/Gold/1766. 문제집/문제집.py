import sys
import heapq

N, M = map(int, sys.stdin.readline().split())

adj = [ [] for i in range(N + 1)] # 인접 리스트
d = [0] * (N + 1) # 진입 간선 갯수
S = [] # 진입 간선 없는 정점들
result = []

# 인접 리스트 생성
for _ in range(M) :
    a, b = map(int, sys.stdin.readline().split())
    adj[a].append(b)
    d[b] += 1

for i in range(1, N + 1) :
    if d[i] == 0 :
        heapq.heappush(S, i)

while S :

    u = heapq.heappop(S)
    result.append(u)

    for v in adj[u] :

        d[v] -= 1

        if d[v] == 0 :
            heapq.heappush(S, v)

for i in result :
    print(i, end = " ")