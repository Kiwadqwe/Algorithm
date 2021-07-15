import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
dx = [-1,0,1,0]
dy = [0,1,0,-1]
result = []

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<m and 0<=ny<n:
                if not visited[nx][ny]:
                    if array[nx][ny] == 1:
                        visited[nx][ny] = True
                        q.append((nx,ny))

for i in range(t):
    m,n,k = map(int,input().split())
    array = [[0] * n for _ in range(m)]
    visited = [[False] * n for _ in range(m)]
    cnt =0

    for j in range(k):
        a,b = map(int,input().split())
        array[a][b] = 1

    for k in range(m):
        for z in range(n):
            if not visited[k][z]:
                if array[k][z] == 1:
                    bfs(k,z)
                    cnt +=1
    result.append(cnt)

for re in result:
    print(re)

# 2
# 10 8 17
# 0 0
# 1 0
# 1 1
# 4 2
# 4 3
# 4 5
# 2 4
# 3 4
# 7 4
# 8 4
# 9 4
# 7 5
# 8 5
# 9 5
# 7 6
# 8 6
# 9 6
# 10 10 1
# 5 5

# 5
# 1