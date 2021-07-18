import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(n)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]
cnt,time =0,0

def outside(x,y):
    global cnt
    q = deque()
    q.append((x,y))
    visited = [[False] * m for _ in range(n)]
    visited[x][y] = True
    array[x][y] = 0
    cnt = 0

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            
            if 0<=nx<n and 0<=ny<m:
                if not visited[nx][ny]:
                    if array[nx][ny]:
                        array[nx][ny] = 0
                        cnt+=1
                    else:
                        q.append((nx,ny))
                    visited[nx][ny] = True
                    
for i in range(n):
    for j in range(m):
        if array[i][j] == 1:
            outside(0,0)
            time+=1

print(time)
print(cnt)

# 13 12
# 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 1 1 0 0 0
# 0 1 1 1 0 0 0 1 1 0 0 0
# 0 1 1 1 1 1 1 0 0 0 0 0
# 0 1 1 1 1 1 0 1 1 0 0 0
# 0 1 1 1 1 0 0 1 1 0 0 0
# 0 0 1 1 0 0 0 1 1 0 0 0
# 0 0 1 1 1 1 1 1 1 0 0 0
# 0 0 1 1 1 1 1 1 1 0 0 0
# 0 0 1 1 1 1 1 1 1 0 0 0
# 0 0 1 1 1 1 1 1 1 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0

# 3
# 5