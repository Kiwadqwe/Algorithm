import sys
from collections import deque
input = sys.stdin.readline

M,N = map(int,input().split())
visited = [[False] * M for _ in range(N)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]
array,q =[],deque()

for i in range(N):
    array.append(list(map(int,input().split())))
    for j in range(M):
        if(array[i][j] == 1):
            q.append((i,j))

def bfs():
    while q:
        x,y = q.popleft()

        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]

            if 0<=nx<N and 0<=ny<M:
                if not visited[nx][ny] and array[nx][ny] == 0:
                    visited[nx][ny] = True
                    array[nx][ny] = array[x][y] + 1
                    q.append((nx,ny))

bfs()
result = 0
check = False
for i in range(N):
    if 0 in array[i]:
        check = True
        break
    result = max(max(array[i]),result)

if check:
    print(-1)
else:
    print(result-1)