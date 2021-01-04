import sys
from collections import deque

input = sys.stdin.readline
dx = [-1,0,1,0]
dy = [0,1,0,-1]

n = int(input())
graph = [list(map(str,input().strip())) for _ in range(n)]
visited = [[False]* n for _ in range(n)]
cnt,rg_cnt = 0,0

def bfs(x,y):
    q = deque()
    q.append((x,y))
    
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                # 방문하지 않은 곳과 색이 같은 곳만 들림
                if not visited[nx][ny] and graph[nx][ny] == graph[x][y]:
                    visited[nx][ny] = True
                    q.append((nx,ny))

# 적록색약이 아닌 사람
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i,j)
            # 같은 색으로만 이루어져있는 곳을 방문하기 위하여
            # 이중 포문안에서 카운트값 증가
            cnt+=1
            
# 빨간색과 초록색을 같다고 봄
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'R':
            graph[i][j] = 'G'

visited = [[False]* n for _ in range(n)]

# 적록색약인 사람
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i,j)
            rg_cnt+=1

print(cnt,rg_cnt)

# 5
# RRRBB
# GGBBB
# BBBRR
# BBRRR
# RRRRR

# 4 3