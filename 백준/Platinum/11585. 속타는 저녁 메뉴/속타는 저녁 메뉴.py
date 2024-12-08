def compute_pi(p) :

    m = len(p)
    pi = [0] * m

    j = 0

    for i in range(1, m) :
        while p[i] != p[j] and j > 0 :
            j = pi[j - 1]
        
        if p[i] == p[j] :
            j += 1
            pi[i] = j
    
    return pi

def find(string, keyword) :
    
    cnt = 0
    i = 0
    j = 0
    
    while i < len(string):
        if string[i] == keyword[j]:
            i += 1
            j += 1
        else:
            if j == 0:
                i += 1
            else:
                j = pi[j-1]

        if j == len(keyword):
            cnt += 1
            j = pi[j-1]

    return cnt

N = int(input())

target = list(map(str, input().split()))
roulette = list(map(str, input().split()))
roulette += roulette[:-1]

pi = compute_pi(target)
target_count = find(roulette, target)


for i in range(target_count, 0, -1):

    if target_count % i == 0 and N % i == 0:
        
        print("{0}/{1}".format(target_count//i, N//i))
        break
