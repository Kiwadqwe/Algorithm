import sys
from collections import deque
input = sys.stdin.readline

m,n,k = map(int,input().split())
dx = [-1,0,1,0]
dy = [0,1,0,-1]
array = [[0] * n for _ in range(m)]
visited = [[0] * n for _ in range(m)]
result = []

for _ in range(k):
    a,b,c,d = map(int,input().split())
    for i in range(a,c):
        for j in range(b,d):
            array[j][i] = -1

def bfs(x,y):
    global cnt,count
    q = deque()
    q.append((x,y))
    array[x][y] = cnt
    visited[x][y] = count

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<m and 0<=ny<n:
                if array[nx][ny] ==0:
                    count+=1
                    visited[nx][ny] = count
                    array[nx][ny] = cnt
                    q.append((nx,ny))
                    
cnt = 0
for i in range(m):
    for j in range(n):
        if array[i][j] == 0:
            # 빈칸의 개수
            cnt +=1
            # 빈칸의 넓이
            count=1
            bfs(i,j)
            result.append(count)
            
result.sort()
print(cnt)
print(*result)

# 5 7 3
# 0 2 4 4
# 1 1 2 5
# 4 0 6 2

# 3
# 1 7 13