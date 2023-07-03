from collections import Counter
import sys

n = int(input())
arr = list(map(int, sys.stdin.readline().split()))
cnt = Counter(arr)

stack = []
result = []

for _ in range(n) :
    result.append(-1)

for i in range(n) :

    if len(stack) == 0 :
        stack.append(i)
    
    else :
        while True :
            if cnt[arr[stack[-1]]] < cnt[arr[i]] :
                result[stack.pop()] = arr[i]

                if len(stack) == 0 :
                    stack.append(i)
                    break
            
            else :
                stack.append(i)
                break

print(*result, end = " ")          