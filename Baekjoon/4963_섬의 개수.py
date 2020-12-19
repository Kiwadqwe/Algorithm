import sys
from collections import deque
input = sys.stdin.readline

# 동서남북 대각선 8방향
dx = [-1,0,1,0,1,1,-1,-1]
dy = [0,1,0,-1,1,-1,1,-1]

def bfs(x,y,w,h):
    q = deque()
    q.append((x,y))

    while q:
        x,y = q.popleft()
        for i in range(8):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<h and 0<=ny<w:
                if not visited[nx][ny] and array[nx][ny]==1:
                    visited[nx][ny] = True
                    array[nx][ny] = 0
                    q.append((nx,ny))
result = []

while True:
    w,h = map(int,input().split())
    array =[]
    visited = [[False] * w for _ in range(h)]
    cnt=0
    
    if not w and not h:
        break

    for _ in range(h):
        array.append(list(map(int,input().split())))

    for i in range(h):
        for j in range(w):
            if array[i][j]:
                cnt+=1
                bfs(i,j,w,h)
    result.append(cnt)
    
for re in result:
    print(re)

# 1 1
# 0
# 2 2
# 0 1
# 1 0
# 3 2
# 1 1 1
# 1 1 1
# 5 4
# 1 0 1 0 0
# 1 0 0 0 0
# 1 0 1 0 1
# 1 0 0 1 0
# 5 4
# 1 1 1 0 1
# 1 0 1 0 1
# 1 0 1 0 1
# 1 0 1 1 1
# 5 5
# 1 0 1 0 1
# 0 0 0 0 0
# 1 0 1 0 1
# 0 0 0 0 0
# 1 0 1 0 1
# 0 0

# 0
# 1
# 1
# 3
# 1
# 9