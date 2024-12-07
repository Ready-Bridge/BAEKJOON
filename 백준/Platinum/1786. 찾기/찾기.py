A = input()
P = input()

def compute_pi(p) :
    m = len(p)

    pi = [0] * (m + 1)
    i = 1
    j = 0

    while i < m:
        if p[i] == p[j] :
            i += 1
            j += 1
            pi[i] = j
    
        elif j == 0 :
            i += 1
            pi[i] = j
        
        else :
            j = pi[j]
    
    return pi

cnt = 0
idx = []

pi = compute_pi(P)
n, m = len(A), len(P)
i = 0
j = 0

while i < n :

    if A[i] == P[j] :
        i += 1
        j += 1
        

        if j == m :
            idx.append(i - j)
            cnt += 1
            j = pi[j]
    
    elif j == 0 :
        i += 1
    
    else :
        j = pi[j]




print(cnt)
idx = map(lambda x : x + 1, idx)
print(" ".join(map(str, idx)))