L = int(input())

A = input()

i = 1
j = 0
pi = [0] * (L + 1)

while i < L:
    if A[i] == A[j] :
        i += 1
        j += 1
        pi[i] = j
    
    elif j == 0 :
        i += 1
        pi[i] = j
    
    else :
        j = pi[j]

print(L - pi[-1])