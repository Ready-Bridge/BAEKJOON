N = int(input())
result = set()

def d(n) :  
  k = str(n)
  if n > 99 : 
      if int(k[0]) - int(k[1])  == int(k[1]) - int(k[2]) :
        result.add(n)
  
  else :
    result.add(n)

for i in range(1, N + 1) :
  d(i)


print(len(result)) 