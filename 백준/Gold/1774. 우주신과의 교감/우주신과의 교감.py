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

N, M = map(int, input().split()) 

node = [0]
edges = []
result = 0
parent = [i for i in range(N + 1)]

for _ in range(N) :
    x, y = map(int, input().split()) 
    node.append((x, y))

for i in range(M) :
    u, v = map(int, input().split())
    union(u, v)
    

for i in range(1, N) :
    for k in range(i + 1, N + 1) :
        w = math.sqrt((node[i][0] - node[k][0]) ** 2 + (node[i][1] - node[k][1]) ** 2)
        edges.append((w, i , k))

edges.sort()

for w, u, v in edges :

    if find(u) != find(v) :
        union(u, v)
        result += w

print("{:.2f}".format(result))