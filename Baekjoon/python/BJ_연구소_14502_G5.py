import sys, copy
from collections import deque
from itertools import combinations
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(N)]
hole = []
hole_cnt ,wall_cnt,virus_cnt = 0,0,0
t_q = deque()
dx = [-1,0,1,0]
dy = [0,1,0,-1]

for i in range(N):
    for j in range(M):
        if array[i][j] == 0:
            hole.append((i,j))
            hole_cnt+=1
        elif array[i][j] == 1:
            wall_cnt+=1
        elif array[i][j] == 2:
            virus_cnt+=1
            t_q.append((i,j))

def bfs(visited,temp,q):
    while q:
        x,y = q.popleft()

        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<N and 0<=ny<M:
                if not visited[nx][ny] and temp[nx][ny] == 0:
                    temp[nx][ny] = 2
                    visited[nx][ny] = True
                    q.append((nx,ny))

def check(temp,safe_cnt):
    for i in range(N):
        for j in range(M):
            if not temp[i][j]:
                safe_cnt+=1
    
    return safe_cnt

result = 0

for c in combinations(hole,3):
    safe_cnt = 0
    visited = [[False] * M for _ in range(N)]
    temp = copy.deepcopy(array)
    
    for x,y in c:
        temp[x][y] = 1
    q = copy.copy(t_q)
    bfs(visited,temp,q)

    safe_cnt = check(temp,safe_cnt)
    result = max(result,safe_cnt)

print(result)