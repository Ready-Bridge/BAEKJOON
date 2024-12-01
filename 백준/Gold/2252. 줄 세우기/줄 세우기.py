import sys
from collections import defaultdict

n, m = map(int, sys.stdin.readline().split())

adj = defaultdict(list) # 그래프를 인접리스트로 표현
result = [] # 결과값 저장
d = [0] * (n + 1) # 해당 정점의 진입 간선 수
S = [] # 진입 간선이 없는 모든 정점

# adj 만들기
for i in range(m) :
    a, b = map(int, sys.stdin.readline().split())
    adj[a].append(b)

# 진입 간선 수 계산 (d 배열)
for u in range(1, n + 1) :
    for v in adj[u] :
        d[v] += 1

for u in range(1, n + 1) :
    if d[u] == 0 :
        S.append(u)

while len(S) != 0 :
    u = S.pop()
    result.append(u)

    for v in adj[u] :
        d[v] -= 1
        if d[v] == 0 :
            S.append(v)

print(*result)