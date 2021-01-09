import sys
import heapq
input = sys.stdin.readline

n = int(input())
array = []
visited = [[-1] * n for _ in range(n)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

for _ in range(n):
    array.append(list(map(int,input().strip())))

def dijkstra():
    q = []
    heapq.heappush(q,(0,0,0))
    visited[0][0] = 0
    cnt =0
    while q:
        cnt,x,y = heapq.heappop(q)
        if x == n-1 and y == n-1:
            break
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if visited[nx][ny] == -1:
                    visited[nx][ny] = cnt
                    if not array[nx][ny]:
                        heapq.heappush(q,(cnt+1,nx,ny))
                    else:
                        heapq.heappush(q,(cnt,nx,ny))
dijkstra()
print(visited[n-1][n-1])

# bfs

# import sys
# from collections import deque
# input = sys.stdin.readline

# n = int(input())
# array = []
# visited = [[-1] * n for _ in range(n)]
# dx = [-1,0,1,0]
# dy = [0,1,0,-1]

# for _ in range(n):
#     array.append(list(map(int,input().strip())))

# def bfs(x,y):
#     q = deque()
#     q.append((x,y))
#     visited[x][y] = 0
    
#     while q:
#         x,y = q.popleft()
#         for i in range(4):
#             nx,ny = x+dx[i],y+dy[i]
#             if 0<=nx<n and 0<=ny<n:
#                 if visited[nx][ny] == -1:
#                     if not array[nx][ny]:
#                         visited[nx][ny] = visited[x][y]+1
#                         q.append((nx,ny))
#                     else:
#                         visited[nx][ny] = visited[x][y]
#                         q.appendleft((nx,ny))
# bfs(0,0)
# print(visited[n-1][n-1])

# 8
# 11100110
# 11010010
# 10011010
# 11101100
# 01000111
# 00110001
# 11011000
# 11000111

# 2