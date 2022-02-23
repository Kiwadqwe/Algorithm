import sys, copy
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(N)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

visited = [[False] * M for _ in range(N)]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True

    while q:
        x,y = q.popleft()

        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]

            if 0<=nx<N and 0<=ny<M:
                if not visited[nx][ny]:
                    if array[nx][ny] != 0:
                        q.append((nx,ny))
                        visited[nx][ny] = True
                    else:
                        if array[x][y] != 0:
                            array[x][y] -= 1

time = 0
while True:
    visited = [[False] * M for _ in range(N)]
    
    cnt = 0

    for i in range(N):
        for j in range(M):
            if array[i][j] != 0 and not visited[i][j]:
                bfs(i,j)
                cnt += 1

    if 2 <= cnt:
        print(time)
        break
    elif cnt == 0:
        print(0)
        break

    time += 1