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


t = int(input())

# 테스트케이스 만큼 반복
for _ in range(t) :

    parent = {}
    cnt = {}

    n = int(input())
    
    # 친구 관계 수 만큼 반복
    for _ in range(n) :
        u, v = input().split()

        if u not in parent :
            parent[u] = u
            cnt[u] = 1
        
        if v not in parent :
            parent[v] = v
            cnt[v] = 1
        
        union(u, v) # 친구 관계 합치기