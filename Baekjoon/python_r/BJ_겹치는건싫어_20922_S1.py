import sys
input = sys.stdin.readline

N,K = map(int,input().split())
array = list(map(int,input().split()))

n = [0] * (max(array)+1)

start,end,result = 0,0,0

while end < N:
    if K <= n[array[end]]:    
        n[array[start]] -= 1
        start+=1
    else:
        n[array[end]] += 1
        end+=1
        
    result = max(result,end-start)
    
print(result)