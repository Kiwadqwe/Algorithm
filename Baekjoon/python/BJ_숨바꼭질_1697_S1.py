import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())

def bfs():
    q = deque()
    q.append((0,N))    
    visited = [False] * 100001
    
    while q:
        cnt,x = q.popleft()
        
        if x == M:
            return cnt
        
        for i in (x-1,x+1,x*2):
            if 0<=i<=100000 and not visited[i]:
                q.append((cnt+1,i))
                visited[i] = True

            
print(bfs())