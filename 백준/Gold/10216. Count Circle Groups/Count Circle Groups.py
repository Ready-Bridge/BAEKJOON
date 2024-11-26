def find(u) :
    if parent[u] == u :
        return u
    
    parent[u] = find(parent[u])
    return parent[u]

def union(u, v):
    ur = find(u)
    vr = find(v)
    if ur != vr:
        parent[vr] = ur 

t = int(input())

for _ in range(t):
    n = int(input())
    parent = [i for i in range(n)]  # 부모 배열 초기화
    info = []

    for i in range(n):
        x, y, r = map(int, input().split())
        for j, (px, py, pr) in enumerate(info):
            # 통신 가능 여부 확인
            if (x - px) ** 2 + (y - py) ** 2 <= (r + pr) ** 2:
                union(i, j)
        info.append((x, y, r))

    # 각 노드의 루트 노드 계산
    cnt = 0
    for i in range(n):
        if i == find(i):  # 자신이 루트인 경우
            cnt += 1

    print(cnt)