import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int,input().split()))

array.sort()

result = 0

for i in range(N):
    s,e = i,N
    
    while s < e:
        m = (s+e)//2
        if array[m] * 0.9 <= array[i]:
            s = m+1
        else:
            e = m
    
    result += e-i-1
    
print(result)
        