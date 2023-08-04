import sys

arr = [True for _ in range(1000001)]

for i in range(2, 1001) :
  if arr[i] :
    for j in range(2 * i, 1000001, i) :
      arr[j] = False


while(True) :
  a = int(sys.stdin.readline())

  if a == 0 :
    break

  for i in range(3, a, 2) :

    if arr[i] and arr[a - i] :
      print("%d = %d + %d"%( a, i, a - i))
      break
    
  else :
    print("Goldbach's conjecture is wrong.")