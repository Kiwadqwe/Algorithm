import sys
from collections import deque
input = sys.stdin.readline

n,m,h = map(int,input().split())
array =[[list(map(int,input().split())) for _ in range(m)] for _ in range(h)]
dx = [-1,0,1,0,0,0]
dy = [0,1,0,-1,0,0]
dz = [0,0,0,0,1,-1]

def bfs():
    q = deque()
    
    for k in range(h):
        for i in range(m):
            for j in range(n):
                if array[k][i][j] == 1:
                    q.append((k,i,j))
    while q:
        z,x,y = q.popleft()
        for i in range(6):
            nz,nx,ny= z+dz[i],x+dx[i],y+dy[i]
            if 0<=nz<h and 0<=nx<m and 0<=ny<n:
                if not array[nz][nx][ny]:
                    array[nz][nx][ny] = array[z][x][y]+1
                    q.append((nz,nx,ny))

bfs()
check = False
result =0

for k in range(h):
    for i in range(m):
        for j in range(n):
            if array[k][i][j] == 0:
                check = True
            result = max(result,array[k][i][j])

if check:
    print(-1)
else:
    print(result-1)

# 5 3 2
# 0 0 0 0 0
# 0 0 0 0 0
# 0 0 0 0 0
# 0 0 0 0 0
# 0 0 1 0 0
# 0 0 0 0 0

# 4