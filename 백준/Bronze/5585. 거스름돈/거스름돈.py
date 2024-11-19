cnt = 0
n = int(input())

n = 1000 - n

arr = [500, 100, 50, 10, 5, 1]

for i in arr :
    while n - i >= 0 :
        cnt += 1
        n -= i

print(cnt)