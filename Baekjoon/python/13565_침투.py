import sys
from collections import deque
input = sys.stdin.readline

m,n = map(int,input().split())
array = [list(map(int,input().strip())) for _ in range(m)]
visited = [[False]* n for _ in range(m)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            if 0<=nx<m and 0<=ny<n:
                if array[nx][ny] == 0 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx,ny))

for i in range(n):
    if array[0][i] == 0 and not visited[0][i]:
        bfs(0,i)

if True in visited[-1]:
    print('YES')
else:
    print('NO')

# 8 8
# 11000111
# 01100000
# 00011001
# 11001000
# 10001001
# 10111100
# 01010000
# 00001011 

# YES