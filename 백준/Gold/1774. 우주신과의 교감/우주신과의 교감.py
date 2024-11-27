import math

def find(u):
    if parents[u] == u:
        return u
    parents[u] = find(parents[u])
    return parents[u]

def union(u, v):
    ur = find(u)
    vr = find(v)
    if ur != vr:
        if ur < vr:
            parents[vr] = ur
        else:
            parents[ur] = vr

n, m = map(int, input().split())

node = dict()
parents = [x for x in range(n + 1)]
edges = []

for i in range(1, n + 1):
    x, y = map(int, input().split())
    node[i] = (x, y)

for i in range(m):
    u, v = map(int, input().split())
    union(u, v)

for u in range(1, n + 1):
    for v in range(u + 1, n + 1):
        if find(u) != find(v) :
            w = math.sqrt((node[u][1] - node[v][1]) ** 2 + (node[u][0] - node[v][0]) ** 2)
            edges.append((u, v, w))

edges.sort(key=lambda x: x[2])

sum = 0

for u, v, w in edges:
    if find(u) != find(v):
        union(u, v)
        sum += w

print("{:.2f}".format(sum))