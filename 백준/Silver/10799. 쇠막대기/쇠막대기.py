arr = list(input())
base = []
result = 0

for i in range(len(arr)) :
    if arr[i] == '(' :
        if arr[i + 1] == ')' :
            result += len(base)
        else :
            base.append('(')
    
    elif arr[i] == ')' :
        if arr[i - 1] == '(' :
          pass
        else :
            base.pop()
            result += 1

print(result)