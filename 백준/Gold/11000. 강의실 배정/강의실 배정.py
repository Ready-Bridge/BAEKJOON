import heapq

n = int(input()) # 수업의 수

arr = [] # 수업 시간을 저장할 배열

for _ in range(n) :
    s, e = map(int ,input().split())
    arr.append((s, e))

arr.sort()

cnt = [] # 강의실의 개수를 구하기 위한 배열

heapq.heappush(cnt, arr[0][1]) # 일단 첫 강의를 위해 강의실을 빌림

for i in range(1, n) :
    
    # 현재 사용중인 강의실 마감시간보다 더 일찍 강의가 시작되는 경우 강의실을 하나 더 빌림
    
    if arr[i][0] < cnt[0] :
        heapq.heappush(cnt, arr[i][1])
    
    # 아닌 경우 해당 강의실을 그대로 사용하면 되므로 마감 시간을 바꿔줌

    else :
        heapq.heappop(cnt)
        heapq.heappush(cnt, arr[i][1])

print(len(cnt))