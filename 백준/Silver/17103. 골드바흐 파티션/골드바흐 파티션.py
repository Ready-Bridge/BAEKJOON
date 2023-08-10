arr = list(True for i in range(1000001))

for i in range(2, 1001) :
    if arr[i] :
        for i in range(i + i, 1000001 , i) :
            arr[i] = False

n = int(input())

for i in range(n) :
    cnt = 0
    a = int(input())

    for i in range(2, a // 2 + 1) :
      if arr[i] :
        if arr[a - i] :
            cnt += 1
  
    print(cnt)