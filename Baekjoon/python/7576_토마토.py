import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
array =[list(map(int,input().split())) for _ in range(m)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

q = deque()

def bfs():
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            if 0<=nx<m and 0<=ny<n:
                if not array[nx][ny]:
                    array[nx][ny] = array[x][y]+1
                    q.append((nx,ny))

for i in range(m):
    for j in range(n):
        if array[i][j] == 1:
            q.append((i,j)) 
bfs()
result = 0
check = True
for i in range(m):
    for j in range(n):
        if array[i][j] == 0:
            check = False
            break
        result = max(result,array[i][j])
    if not check:
        break

if check:
    print(result-1)
else:
    print(-1)

# 6 4
# 0 0 0 0 0 0
# 0 0 0 0 0 0
# 0 0 0 0 0 0
# 0 0 0 0 0 1

# 8