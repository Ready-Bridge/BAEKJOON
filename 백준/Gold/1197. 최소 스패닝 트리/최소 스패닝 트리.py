import sys
sys.setrecursionlimit(10 ** 6)

def find(u) :
    if parents[u] == u :
        return u
    
    parents[u] = find(parents[u])
    return parents[u]

def union(u, v) :
    ur = find(u)
    vr = find(v)

    if ur != vr :
        if ur < vr :
            parents[vr] = ur
        
        else :
            parents[ur] = vr

v, e = map(int, input().split())

mst = []
edges = []
parents = [x for x in range(v + 1)]

for _ in range(e) :
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

edges.sort(key = lambda x : x[2])

for u, v, w in edges :
    if find(u) != find(v) :
        mst.append((u, v, w))
        union(u, v)

sum = 0

for x in mst :
    sum += x[2]

print(sum)