import sys
from collections import deque
input = sys.stdin.readline

dx = [-2,-2,0,0,2,2]
dy = [-1,1,-2,2,-1,1]

N = int(input())
x,y,r,c = map(int,input().split())
visited = [[False] * N for _ in range(N)]

def bfs(x,y):
    q = deque() 
    q.append((x,y,0))
    visited[x][y] = True

    while q:
        x,y,cnt = q.popleft()

        if x == r and y == c:
            return cnt

        for i in range(6):
            nx,ny = x+dx[i],y+dy[i]

            if 0<=nx<N and 0<=ny<N:
                if not visited[nx][ny]:
                    q.append((nx,ny,cnt+1))
                    visited[nx][ny] = True

    return -1
    
print(bfs(x,y))