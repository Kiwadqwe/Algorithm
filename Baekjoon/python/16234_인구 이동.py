import sys
from collections import deque
input = sys.stdin.readline

n,l,r = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(n)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(x,y,idx):
    q = deque()
    q.append((x,y))
    # 연결된 나라 좌표
    nation = []
    nation.append((x,y))
    # 연합 번호
    team[x][y] = idx
    # 인구수
    people = array[x][y]
    # 연합의 국가 수
    cnt = 1

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n and team[nx][ny] == -1:
                if l<=abs(array[nx][ny]-array[x][y])<=r:
                    team[nx][ny] = idx
                    people+= array[nx][ny]
                    cnt+=1
                    q.append((nx,ny))
                    nation.append((nx,ny))
                    
    for i,j in nation:
        array[i][j] = people//cnt
    return cnt

total_cnt = 0

while True:
    team = [[-1] * n for _ in range(n)]
    idx = 0
    for i in range(n):
        for j in range(n):
            if team[i][j] == -1:
                bfs(i,j,idx)
                idx+=1

    if idx == n*n:
        break

    total_cnt+=1

print(total_cnt)

# 2 20 50
# 50 30
# 20 40

# 1

# 2 40 50
# 50 30
# 20 40

# 0

# 3 5 10
# 10 15 20
# 20 30 25
# 40 22 10

# 2