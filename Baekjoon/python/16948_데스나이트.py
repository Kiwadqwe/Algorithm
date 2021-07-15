import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
r1,c1,r2,c2 = map(int,input().split())
dx = [-2,-2,0,0,2,2]
dy = [-1,1,-2,2,-1,1]
cnt = 0
visited = [[False] * n for _ in range(n)]

def bfs(x,y):
    global cnt
    q = deque()
    q.append((x,y,cnt))
    visited[x][y] = True

    while q:
        x,y,cnt = q.popleft()
        
        if x == r2 and y == c2:
            return cnt
        for i in range(6):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx,ny,cnt+1))
    return -1

print(bfs(r1,c1))

# 7
# 6 6 0 1

# 4

# 7
# 6 6 0 1

# -1