import sys
from collections import deque
input = sys.stdin.readline

N,M,K = map(int,input().split())

array = [list(map(int,input().strip())) for _ in range(N)]
dx,dy = [0,1,0,-1],[-1,0,1,0]

def bfs():
    q = deque()
    q.append((1,0,0,K))
    visited = [[[False] * (K+1) for _ in range(M)] for _ in range(N)]
    visited[0][0][K] = True
    
    while q:
        cnt,x,y,k = q.popleft()
        
        if x == N-1 and y == M-1:
            return cnt

        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<N and 0<=ny<M:
                if k == 0:
                    if array[nx][ny] == 0:    
                        if not visited[nx][ny][0]:
                            q.append((cnt+1,nx,ny,0))
                            visited[nx][ny][0] = True
                else:
                    if array[nx][ny] == 1:
                        if not visited[nx][ny][k-1]:
                            q.append((cnt+1,nx,ny,k-1))
                            visited[nx][ny][k-1] = True
                    else:
                        if not visited[nx][ny][k]:
                            q.append((cnt+1,nx,ny,k))
                            visited[nx][ny][k] = True
                    
    return -1

print(bfs())