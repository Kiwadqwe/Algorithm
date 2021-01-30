import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
array = [list(map(int,input().split())) for _ in range(n)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

cnt =0

def bfs(x,y,land):
    q = deque()
    q.append((x,y))
    
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=nx<n:
                if array[nx][ny]:
                    array[nx][ny] = land
                    q.append((nx,ny))

land =1

# 육지 그룹화
for i in range(n):
    for j in range(n):
        if array[i][j]:
            land+=1
            array[i][j] = land
            bfs(i,j,land)

d = int(1e9)
print(array)

def bfs2(land):
    global d
    q =deque()
    dis = [[-1] *n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if array[i][j] == land:
                q.append((i,j))
                dis[i][j] = 0
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if array[nx][ny] != land and array[nx][ny]:
                    d = min(d, dis[x][y])
                    return

                if dis[nx][ny] == -1 and not array[nx][ny]:
                    dis[nx][ny] = dis[x][y] +1
                    q.append((nx,ny))


# for i in range(1,land):
#     bfs2(i)

print(d)

# 10
# 1 1 1 0 0 0 0 1 1 1
# 1 1 1 1 0 0 0 0 1 1
# 1 0 1 1 0 0 0 0 1 1
# 0 0 1 1 1 0 0 0 0 1
# 0 0 0 1 0 0 0 0 0 1
# 0 0 0 0 0 0 0 0 0 1
# 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 1 1 0 0 0 0
# 0 0 0 0 1 1 1 0 0 0
# 0 0 0 0 0 0 0 0 0 0

# 3