import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = list(map(int,input().split()))
visited = [False] * (N+1)
start,end,result,cnt = 0,0,int(1e9),0

if array[end] == 1:
    cnt+=1

while start < N and end < N:
    if cnt < M and end <= N-2:
        end+=1
        
        if array[end] == 1:
            cnt+=1
    else:
        if cnt == M:
            result = min(result,end-start+1)
        
        if array[start] == 1 and end <= N-1:
            cnt-=1
        start+=1
        
if result == int(1e9):
    print(-1)
else:
    print(result)