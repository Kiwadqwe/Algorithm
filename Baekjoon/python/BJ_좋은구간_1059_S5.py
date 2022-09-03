import sys
input = sys.stdin.readline

L = int(input())
array = list(map(int,input().split()))
N = int(input())

if N in array: 
    print(0)
    sys.exit()

array.append(0)
array.sort()

A = 0
B = 0

for i in range(len(array)):
    if array[i] < N:
        A = i
    else:
        break

for i in range(A+1,len(array)):
    if N < array[i]:
        B = array[i]
        break

A = array[A]
cnt = 0

cnt+= (B-N) * (N-(A+1))
cnt+= B-N-1
    
print(cnt)