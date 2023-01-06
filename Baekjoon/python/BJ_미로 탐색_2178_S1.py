import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(input().rstrip()) for _ in range(N)]

def bfs():
    q = deque()
    visited = [[False] * M for _ in range(N)]
    q.append((0,0,1))
    visited[0][0] = True
    dx,dy = [0,1,0,-1],[-1,0,1,0]
    
    while q:
        x,y,cnt = q.popleft()
        
        if x == N-1 and y == M-1:
            return cnt

        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<N and 0<=ny<M:
                if not visited[nx][ny] and array[nx][ny] == '1':
                    visited[nx][ny] = True
                    q.append((nx,ny,cnt+1))
                    
print(bfs())
    