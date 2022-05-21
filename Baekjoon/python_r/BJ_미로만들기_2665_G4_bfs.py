import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
array = [list(map(str,input())) for _ in range(N)]
visited = [[[False for _ in range(N*N)] for _ in range(N)] for _ in range(N)]

dx = [-1,0,1,0]
dy = [0,1,0,-1]
result = int(1e9)

def bfs():
    global result
    q = deque()
    q.append((0,0,0))
    visited[0][0][0] = True

    while q:
        x,y,cnt = q.popleft()

        if cnt >= result:
            continue

        if x == N-1 and y == N-1:
            result = min(result,cnt)

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            
            if 0<=nx<N and 0<=ny<N:
                if array[nx][ny] == '0' and not visited[nx][ny][cnt+1]:
                    visited[nx][ny][cnt+1] = True
                    q.append((nx,ny,cnt+1))
                elif array[nx][ny] == '1' and not visited[nx][ny][cnt]:
                    visited[nx][ny][cnt] = True
                    q.append((nx,ny,cnt))

    return result

print(bfs())