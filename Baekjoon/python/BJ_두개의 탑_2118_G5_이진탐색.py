import sys
input = sys.stdin.readline

N = int(input())

array = [0] * (N+1)
 
for i in range(1,N+1):
    a = int(input())
    array[i] = array[i-1]+a

result = 0

for i in range(1,N):
    s = i
    e = N
    while s <= e:
        m = (s+e)//2
        a = array[m]-array[i-1]
        b = array[N]-a
        if a < b:
            s = m+1
        else:
            e = m-1
        
        result = max(result,min(a,b))
        
        
print(result)