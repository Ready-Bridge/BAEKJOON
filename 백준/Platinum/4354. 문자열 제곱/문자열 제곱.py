def compute_pi(p) :

    m = len(p)
    pi = [0] * m
    j = 0

    for i in range(1, m) :
        while j > 0 and p[i] != p[j] :
            j = pi[j - 1]
        
        if p[i] == p[j] :
            j += 1
            pi[i] = j
    
    return pi

while True :
    
    A = input()
    
    if A == "." :
        break

    pi = compute_pi(A)

    if len(A) % (len(A) - pi[-1]) != 0 :
        print(1)
    
    else :
        print(len(A) // (len(A) - pi[-1]))