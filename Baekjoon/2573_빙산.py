import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(n)]
dx = [0,1,0,-1]
dy = [-1,0,1,0]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True 
    
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            if 0<=nx<n and 0<=ny<m:
                if not visited[nx][ny]:
                    if array[nx][ny] == 0:
                        if array[x][y]:
                            array[x][y] -=1
                    else:
                        visited[nx][ny] = True
                        q.append((nx,ny))
year = 0

while 1:
    cnt = 0
    visited = [[False] * m for _ in range(n)]

    # 빙하 덩어리의 개수
    for i in range(n):
        for j in range(m):
            if array[i][j] and not visited[i][j]:
                bfs(i,j)
                cnt +=1
    if cnt >=2:
        print(year)
        break
    elif cnt==0:
        print(0)
        break
    year+=1

# 5 7
# 0 0 0 0 0 0 0
# 0 2 4 5 3 0 0
# 0 3 0 2 5 2 0
# 0 7 6 2 4 0 0
# 0 0 0 0 0 0 0

# 2