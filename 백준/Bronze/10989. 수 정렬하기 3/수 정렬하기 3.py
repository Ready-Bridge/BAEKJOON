import sys

N = int(sys.stdin.readline())

arr = [0] * 10001

for i in range(N) :
    n = int(sys.stdin.readline())
    arr[n] += 1

for i in range(1, 10001) :
    if arr[i] != 0 :
        for k in range(arr[i]) :
            print(i)