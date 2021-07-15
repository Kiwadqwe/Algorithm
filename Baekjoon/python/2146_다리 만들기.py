import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
array = [list(map(int,input().split())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(x,y,group):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    array[x][y] = group
    while q:
        x,y= q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if not visited[nx][ny] and array[nx][ny] == 1:
                    visited[nx][ny] = True
                    array[nx][ny] = group
                    q.append((nx,ny))

group = 2
# 육지 그룹화
for i in range(n):
    for j in range(n):
        if not visited[i][j] and array[i][j] == 1:
            bfs(i,j,group)
            group+=1

result = int(1e9)

def bfs2(group):
    global result
    q = deque()
    cnt = [[-1] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if array[i][j] == group:
                cnt[i][j] = 0
                q.append((i,j))
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if array[nx][ny] != group and array[nx][ny] !=0:
                    # 다리의 최소 개수
                    result = min(result, cnt[x][y])
                    return
                
                if cnt[nx][ny] == -1:
                    cnt[nx][ny] = cnt[x][y]+1
                    q.append((nx,ny))
                    
for i in range(2,group+1):
    bfs2(i)

print(result)

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