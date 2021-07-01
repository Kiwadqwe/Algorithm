import sys
from collections import deque
input = sys.stdin.readline

r,c = map(int,input().split())
array = [list(input().strip()) for _ in range(r)]
visited = [[-1] * c for _ in  range(r)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]
q = deque()

def bfs(x,y):
    q.append((x,y,1))
    visited[x][y] = 0
    # check 가 1일때는 고슴도치 이동, 0일때는 물 이동
    check = 0

    while q:
        x,y,check = q.popleft()
        print('\n')
        print(x,y,check)
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            if 0<=nx<r and 0<=ny<c:
                if visited[nx][ny] == -1:
                    # 물과 고슴도치 이동
                    if array[nx][ny] == '.' or array[nx][ny] == 'S':
                        visited[nx][ny] = visited[x][y]+1
                        q.append((nx,ny,check))
                    # 두더지까지 도착 했을 때
                    elif array[nx][ny] == 'D':
                        if not check:
                            continue
                        visited[nx][ny] = visited[x][y]+1
                        return print(visited[x][y]+1)
    print('KAKTUS')

for i in range(r):
    for j in range(c):
        if array[i][j] == 'S':
            x,y = i,j
            visited[i][j] = 0
        elif array[i][j] == '*':
            q.append((i,j,0))

bfs(x,y)

# 3 3
# D.*
# ...
# .S.

# 3

# 3 3
# D.*
# ...
# ..S

# KAKTUS