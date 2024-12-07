from collections import defaultdict

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
        cnt[ur] += cnt[vr]
    
    print(cnt[ur])

T = int(input())

for _ in range(T) :

    # 친구 수를 세는 cnt와 parent를 각각 만듬
    parent = {}
    cnt = {}

    F = int(input())

    for _ in range(F) :
        u, v = input().split()

        if not u in parent :
            parent[u] = u
            cnt[u] = 1

        if not v in parent :
            parent[v] = v
            cnt[v] = 1
        
        union(u, v)