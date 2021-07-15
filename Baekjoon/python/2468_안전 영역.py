import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
array = [list(map(int,input().split())) for _ in range(n)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]
result = 0

def bfs(x,y,height,cnt):
    q = deque()
    q.append((x,y))
    visited[x][y] = cnt

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if not visited[nx][ny]:
                    if array[nx][ny] > height:
                        visited[nx][ny] = cnt
                        q.append((nx,ny)) 

for k in range(max(max(array))+1):
    visited = [[0] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and array[i][j] >k:
                cnt+=1
                bfs(i,j,k,cnt)
    result = max(result,cnt)

print(result)

# 5
# 6 8 2 6 2
# 3 2 3 4 6
# 6 7 3 3 2
# 7 2 5 3 6
# 8 9 5 2 7

# 5