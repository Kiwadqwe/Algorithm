import sys,copy
from collections import deque
from itertools import combinations
input = sys.stdin.readline

n,m = map(int,input().split())
temp = [list(map(int,input().split())) for _ in range(n)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]
tp = []

for i in range(n):
    for j in range(m):
        if temp[i][j] == 0:
            tp.append((i,j))

# 바이러스를 퍼트려 bfs로
def virus(x,y,visited):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    array[x][y] = 2

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            if 0<=nx<n and 0<=ny<m:
                if not visited[nx][ny]:
                    if not array[nx][ny]:
                        array[nx][ny] = 2
                        visited[nx][ny] = True
                        q.append((nx,ny))

def virus_search():
    visited = [[False] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if not visited[i][j]:
                if array[i][j] == 2:
                    virus(i,j,visited)
                   
cnt = 0
def safe_search():
    global cnt
    cnt = 0
    for i in range(n):  
        for j in range(m):
            if array[i][j] == 0:
                cnt += 1

result = 0

for cm in combinations(tp,3):
    array = copy.deepcopy(temp)
    for x,y in cm:
        array[x][y] = 1
    virus_search()
    safe_search()
    result = max(result,cnt)
    
print(result)

# 4 6
# 0 0 0 0 0 0
# 1 0 0 0 0 2
# 1 1 1 0 0 2
# 0 0 0 0 0 2

# 9