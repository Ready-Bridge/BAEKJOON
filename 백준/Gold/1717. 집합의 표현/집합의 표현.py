import sys
sys.setrecursionlimit(10 ** 6)

def find_set(u) :
    if parent[u] == u :
        return u
    
    parent[u] = find_set(parent[u])
    return parent[u]

def union_set(u, v) :
    ur = find_set(u)
    vr = find_set(v)
    
    if ur != vr :
        parent[vr] = ur  
        

n, m = map(int, input().split())

parent = [i for i in range(n + 1)]

for line in sys.stdin :
    flag, u, v = map(int, line.split()) 

    if flag == 1 :
        if find_set(u) == find_set(v) :
            print("yes")
        
        else :
            print("no")

    else :
        union_set(u, v)