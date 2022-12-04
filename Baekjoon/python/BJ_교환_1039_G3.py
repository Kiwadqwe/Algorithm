import sys
from collections import deque
input = sys.stdin.readline

N,K = map(int,input().split())

def swap(i,j,list_N):
    list_N[i],list_N[j] = list_N[j],list_N[i]

def bfs():
    q = deque()
    q.append((0,N))
    visited = [[False] * 1000001 for _ in range(K+1)]
    result = -1
    
    while q:
        cnt,x = q.popleft()
        if K < cnt: continue
        
        if K == cnt:
            result = max(result,x)

        list_N = list(map(int,str(x)))

        for i in range(len(list_N)-1):
            for j in range(i+1,len(list_N)):
                swap(i,j,list_N)
                
                new_N = int(''.join(map(str,list_N)))
                
                if len(str(new_N)) != len(str(N)):
                    swap(i,j,list_N)
                    continue
                
                if not visited[cnt][new_N]:
                    q.append((cnt+1,new_N))
                    visited[cnt][new_N] = True
                
                swap(i,j,list_N)

    return result        

print(bfs())