from collections import deque
import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(map(str,input().strip())) for _ in range(N)]
visited = [[[False] * 2 for _ in range(M)] for _ in range(N)] 

dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs():
    q = deque()
    visited[0][0][0] = True
    q.append((1,0,0,0))
    
    while q:
        cnt,s,x,y = q.popleft()
        
        if x == N-1 and y == M-1:
            return cnt
        
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<N and 0<=ny<M:
                if not visited[nx][ny][s]:
                    if array[nx][ny] == '1' and s == 0:
                        visited[nx][ny][1] = True
                        q.append((cnt+1,1,nx,ny))
                    elif array[nx][ny] == '0':
                        visited[nx][ny][s] = True
                        q.append((cnt+1,s,nx,ny))
                        
    return -1

print(bfs())