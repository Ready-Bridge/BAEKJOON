import sys

T = int(input())

for _ in range(T) :
    n = int(input()) # 팀 수
    team = [-1] + list(map(int, sys.stdin.readline().split())) # i등을 한 팀 번호
    m = int(input()) # 등수가 바뀐 팀 쌍 수
    adj = [[] for _ in range(n + 1)] # 인접 리스트
    d = [0] * (n + 1) # 진입 간선 수
    S = [] # 진입 간선 없는 정점들
    result = []
    flag = 0


    # 순위별로 선 후 관계를 명시해줌
    # 1등, 2등이 있다면 1등 -> 2등 순으로
    # 이때 이중 for문으로 1등 -> 2등, 1등 -> 3등, 1등 -> 4등 ... 하위 순위들 전부 연결

    for u in range(1, n + 1) :
        for v in range(u + 1, n + 1) :
            adj[team[u]].append(team[v])
            d[team[v]] += 1 

    # 등수가 바뀌면 선 후 관계도 바뀜

    for _ in range(m) :
        a, b = map(int, sys.stdin.readline().split())
        
        if b in adj[a] :
            adj[a].remove(b)
            adj[b].append(a)
            d[b] -= 1
            d[a] += 1
        
        else :
            adj[b].remove(a)
            adj[a].append(b)
            d[a] -= 1
            d[b] += 1

    for i in range(1, n + 1) :
        if d[i] == 0 :
            S.append(i)
    
    # S가 없는 경우 => 순위 정할 수 없음 => IMPOSSIBLE
    if len(S) == 0 :
        print("IMPOSSIBLE")
        continue
    
    else :

        while S :

            u = S.pop()
            result.append(u)

            for v in adj[u] :
                d[v] -= 1
                
                # S에 값이 여러개 담긴 경우 => 확실한 순위를 못찾음 => ?
                if len(S) >= 2 :
                    flag = 1
                    break
                else :
                    if d[v] == 0 :
                        S.append(v)

            if flag :
                print('?')
                break

    if flag :
        continue
    
    # 중간에 끊겨서 최종 순위 못정하는 경우 => IMPOSSIBLE
    
    if len(result) == n :
        print(" ".join(map(str, result)))      

    else :
        print("IMPOSSIBLE")  