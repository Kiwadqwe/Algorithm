# dijkstra
import sys
import heapq
input = sys.stdin.readline

n, m = map(int,input().split())

array = []
visited = [[-1]* n for _ in range(m)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

for _ in range(m):
    array.append(list(map(int,input().strip())))

def dijkstra(x,y):
    q = []
    cnt = 0
    heapq.heappush(q,(cnt,x,y))
    visited[0][0] = 0

    while q:
        cnt,x,y = heapq.heappop(q)
        if x == m-1 and y == n-1:
            return
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<m and 0<=ny<n:
                if visited[nx][ny] == -1:
                    visited[nx][ny] = cnt
                    if array[nx][ny]:
                        heapq.heappush(q,(cnt+1,nx,ny))
                    else:
                        heapq.heappush(q,(cnt,nx,ny))
dijkstra(0,0)
print(visited[m-1][n-1])

# bfs

# import sys
# from collections import deque
# input = sys.stdin.readline

# m,n = map(int,input().split())
# graph=[list(map(int,input())) for i in range(n)]

# dx=[-1,0,1,0]
# dy=[0,1,0,-1]

# visited=[[-1] *m for i in range(n)]
# visited[0][0]=0


# q=deque()
# q.append([0,0])
# def bfs():
#     while q:
#         x,y=q.popleft()
#         for i in range(4):
#             nx= x+dx[i]
#             ny= y+dy[i]
#             if 0<=nx<n and 0<=ny<m:
#                 if visited[nx][ny]==-1:
#                     if graph[nx][ny]==1:
#                         q.append([nx,ny])
#                         visited[nx][ny]=visited[x][y]+1
#                     else:
#                         q.appendleft([nx,ny])
#                         visited[nx][ny]=visited[x][y]
# bfs()
# print(visited[n-1][m-1])

# 3 3
# 011
# 111
# 110

# 3

# 4 2
# 0001
# 1000

# 0