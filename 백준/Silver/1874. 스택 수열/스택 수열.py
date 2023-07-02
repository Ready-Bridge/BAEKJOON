n = int(input())
compare = list()
myStack = list()
result = list()
cnt_compare = 0
cnt_num = 1
flag = True


for i in range(n) :
  compare.append(int(input()))

myStack.append(cnt_num)
cnt_num += 1
result.append('+')

while compare:
  if len(myStack) == 0 :
    myStack.append(cnt_num)
    cnt_num += 1
    result.append('+')

  elif myStack[-1] < compare[0] :
    myStack.append(cnt_num)
    cnt_num += 1
    result.append('+')

  
  elif myStack[-1] == compare[0] :
    compare.pop(0)
    myStack.pop()
    result.append('-')
    
  
  else :
    flag = False
    break

if flag :
  for i in result :
    print(i)

else :
  print("NO")