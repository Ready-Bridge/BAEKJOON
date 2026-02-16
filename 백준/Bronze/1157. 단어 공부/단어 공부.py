a = {}

word = input().upper()
for i in word :
    if i in a :
        a[i] += 1
    
    else :
        a[i] = 1

num = max(a.values())
cnt = 0

for k,v in a.items() :
    if v == num :
        result = k
        cnt += 1

if cnt == 1 :
    print(result)

else :
    print('?')