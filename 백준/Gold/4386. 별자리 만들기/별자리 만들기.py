import sys
import math

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

n = int(input())

parent = [i for i in range(n)]
node = []
edges = []
result = 0

for _ in range(n) :
    x, y = map(float, input().split())
    node.append((x, y))

for i in range(n - 1) :
    for k in range(i + 1, n) :
        w = math.sqrt((node[i][0] - node[k][0]) ** 2 + (node[i][1] - node[k][1]) ** 2)
        edges.append((w, i, k))

edges.sort()

for w, u, v in edges :
    if find(u) != find(v) :
        union(u, v)
        result += w

print(round(result, 2))