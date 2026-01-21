N, M = map(int,input().split())
pack = list()
notg = list()

for i in range(M) :
  a, b = map(int,input().split())
  pack.append(a)
  notg.append(b)

min_pack = min(pack)
min_notg = min(notg)


if min_pack >= min_notg * 6 :
  print(min_notg * N)

else :
  if (N % 6) * min_notg > min_pack : 
    print(min_pack * (N // 6 + 1))
  
  else :  
    print(min_pack * (N // 6) + min_notg * (N % 6))