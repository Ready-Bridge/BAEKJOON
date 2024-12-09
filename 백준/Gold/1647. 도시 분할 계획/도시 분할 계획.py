def find(u) :
    if parent[u] == u :
        return u

    parent[u] = find(parent[u])

    return parent[u]

def union(u, v) :
    ur = find(u)
    vr = find(v)

    if ur != vr :
        parent[vr] = ur

N, M = map(int, input().split())

edges = []
parent = [i for i in range(N + 1)]

for _ in range(M) :
    u, v, w = map(int, input().split())
    edges.append((u, v, w))

edges.sort(key = lambda x : x[2])

cnt = 0
last_edge = 0 

# 최소 신장 트리 구하고 
# 그 가중치에서 마지막으로 연결한 edge의 가중치 빼주면 2개의 마을로 분리되고 임의의 두 집 사이에 경로가 항상 존재

for u, v, w in edges :
    if find(u) != find(v) :
        union(u, v)
        cnt += w
        last_edge = w

print(cnt - last_edge)