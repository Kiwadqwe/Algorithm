import sys
input = sys.stdin.readline

N,K = map(int,input().split())

array = list(map(int,input().split()))

start,end,hap,l,result = 0,0,array[0],1,-int(1e9)

while start < N-K+1:
    if l < K and end < N-1:
        end+=1
        l+=1
        hap += array[end]
        
    else:
        if K == l:
            result = max(result,hap)
            hap -= array[start]
            start+=1
            l-=1
        
print(result)
