cnt = 0

n = int(input())

arr = []

for i in range(n) :
    start, end = map(int, input().split())
    arr.append((start, end))

arr.sort(key = lambda x : (x[1], x[0])) # 두 번 째 원소로 오름차순 정렬 => 같은 경우 첫 번 째 원소로 오름차순

# 이전 end 값 저장을 위한 변수
e = 0

for i in arr :
    if i[0] >= e :
        cnt += 1
        e = i[1]

print(cnt)