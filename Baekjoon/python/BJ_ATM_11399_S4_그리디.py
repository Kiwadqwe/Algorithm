import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int,input().split()))
array.sort()
t = sum(array)
result = sum(array)

for i in range(len(array)-1,-1,-1):
    t -= array[i]
    result += t

print(result)