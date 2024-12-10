def find(u):
    if parent[u] == u:
        return u
    parent[u] = find(parent[u])  # Path compression
    return parent[u]

def union(u, v):
    ur = find(u)
    vr = find(v)
    if ur != vr:
        parent[vr] = ur

n, m, k = map(int, input().split())  # 도시의 개수, 케이블의 개수, 발전소의 개수

arr_k = list(map(int, input().split()))  # 발전소

parent = [i for i in range(n + 1)]
edges = []
cnt = 0

# 발전소가 있는 곳들을 같은 집합으로 연결
for i in range(k - 1):
    union(arr_k[i], arr_k[i + 1])

for i in range(m):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))

edges.sort(key=lambda x: x[2])  # 간선 가중치로 정렬

for u, v, w in edges:
    if find(u) != find(v):  # 같은 집합이 아니라면
        union(u, v)
        cnt += w

print(cnt)