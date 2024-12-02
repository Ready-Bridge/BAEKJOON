import sys
from collections import defaultdict

T = int(sys.stdin.readline())

for _ in range(T):
    N, K = map(int, sys.stdin.readline().split())

    d = [0] * (N + 1)  # 각 정점별 진입 간선 수
    adj = defaultdict(list)
    D = [0] + list(map(int, sys.stdin.readline().split()))  # 각 건물당 걸리는 시간
    cnt = [0] * (N + 1)

    # 그래프 생성
    for _ in range(K):
        u, v = map(int, sys.stdin.readline().split())
        adj[u].append(v)
        d[v] += 1

    win = int(sys.stdin.readline())  # 목표 건물 번호

    # 진입 차수 0인 노드 리스트에 추가
    S = []
    for i in range(1, N + 1):
        if d[i] == 0:
            S.append(i)
            cnt[i] = D[i]

    while S :
        u = S.pop()  

        for v in adj[u]:
            d[v] -= 1
            cnt[v] = max(cnt[v], cnt[u] + D[v])
            if d[v] == 0:
                S.append(v)

        if d[win] == 0 :
            print(cnt[win])
            break
