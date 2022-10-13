import sys
input = sys.stdin.readline

N = int(input())

array = list(map(int,input().split()))

s,e = 0,N-1
m = 0
result = 0

while s<e:
    m = (e-s-1) * min(array[s],array[e])
    result = max(result,m)

    if array[s] < array[e]:
        s+=1
    else:
        e-=1

print(result)