def find(u) :
    if parent[u] == u :
        return u
    
    parent[u] = find(parent[u])
    return parent[u]

def union(u, v) :

    ur = find(u)
    vr = find(v)

    if ur != vr :
        if money[ur] > money[vr] :
            money[ur] = 0
            parent[ur] = vr
        
        else :
            money[vr] = 0
            parent[vr] = ur
        

n, m, k = map(int, input().split())
money = [0] + list(map(int,input().split())) # 각 친구비

parent = [i for i in range(n + 1)]

for i in range(m) :
    u, v = map(int, input().split())
    union(u, v)

cost = sum(money)

if cost > k :
    print("Oh no")

else :
    print(cost)