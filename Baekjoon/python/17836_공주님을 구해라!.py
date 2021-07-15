import sys
from collections import deque
input = sys.stdin.readline

n,m,t = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(n)]

dx = [-1,0,1,0]
dy = [0,1,0,-1]
visited = [[False] * m for _ in range(n)]

def bfs():
    q = deque()
    q.append((0,0,0))
    visited[0][0] = True
    c = int(1e9)

    while q:
        x,y,cnt = q.popleft()
        if array[x][y] == 2:
            c = n-1-x+m-1-y+cnt
        if x == n-1 and y == m-1:
            return min(cnt,c)
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            if 0<=nx<n and 0<=ny<m:
                if array[nx][ny] != 1:
                    if not visited[nx][ny]:
                        visited[nx][ny] = True
                        q.append((nx,ny,cnt+1))
    return c

cnt = bfs()
if cnt <= t:
    print(cnt)
else:
    print('Fail')

# 6 6 16
# 0 0 0 0 1 1
# 0 0 0 0 0 2
# 1 1 1 0 1 0
# 0 0 0 0 0 0
# 0 1 1 1 1 1
# 0 0 0 0 0 0

# 10

# 3 4 100
# 0 0 0 0
# 1 1 1 1
# 0 0 2 0

# Fail