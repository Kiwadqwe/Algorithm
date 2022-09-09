import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())
X,Y = 0,0
array = [[] for _ in range(N)]

fire = deque()
q = deque()
visited = [[False] * M for _ in range(N)]
dx,dy = [-1,0,1,0],[0,1,0,-1]

for i in range(N):
    a = input()
    for j in range(len(a)):
        array[i].append(a[j])
        
        if a[j] == 'J':
            visited[i][j] = True
            q.append((i,j,0))            
        elif a[j] == 'F':
            fire.append((i,j))
            
def bfs():
    while q:
        l = len(fire)
        for i in range(l):
            x,y = fire.popleft()
            
            for i in range(4):
                nx,ny = x+dx[i],y+dy[i]
                
                if 0<=nx<N and 0<=ny<M:
                    if array[nx][ny] == '.':
                        array[nx][ny] = 'F'
                        fire.append((nx,ny))
                        
        l = len(q)
        for i in range(l):
            x,y,cnt = q.popleft()

            for i in range(4):
                nx,ny = x+dx[i],y+dy[i]
                
                if 0<=nx<N and 0<=ny<M:
                    if array[nx][ny] == '.' and not visited[nx][ny]:
                        visited[nx][ny] = True
                        q.append((nx,ny,cnt+1))
                else:
                    return cnt+1

result = bfs()

if not result:
    print("IMPOSSIBLE")
else:
    print(result)