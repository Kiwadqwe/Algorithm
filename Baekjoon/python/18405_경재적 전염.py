import sys
from collections import deque
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,1,0,-1]
n,k = map(int,input().split())

array,tp = [],[]
cnt = 0
for i in range(n):
    array.append(list(map(int,input().split())))
    for j in range(n):
        if array[i][j]:
            tp.append((array[i][j],i,j,cnt))

s,x,y = map(int,input().split())

def bfs():
    global cnt
    while q:
        v,x,y,cnt = q.popleft()
        if cnt == s:
            return
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            if 0<=nx<n and 0<=ny<n:
                if not array[nx][ny]:
                    array[nx][ny] = v
                    q.append((v,nx,ny,cnt+1))
                    
q = deque(sorted(tp))
bfs()

if array[x-1][y-1]: 
    print(array[x-1][y-1])
else: 
    print(0)

# 3 3
# 1 0 2
# 0 0 0
# 3 0 0
# 2 3 2

# 3