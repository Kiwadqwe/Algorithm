# dfs
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

r,c = map(int,input().split())
array = [list(map(lambda x: str(x),input().strip())) for _ in range(r)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

result = 0
al = array[0][0]

def dfs(x,y,al):
    global result
    for i in range(4):
        nx,ny = x+dx[i],y+dy[i]
        if 0<=nx<r and 0<=ny<c and array[nx][ny] not in al:
            dfs(nx,ny,al+array[nx][ny])
        result = max(len(al),result)

dfs(0,0,al)
print(result)

# bfs

# def bfs(x,y):
#     global result
#     q = set([(x,y,array[0][0])])
#     while q:
#         x,y,al = q.pop()
#         result = max(len(al),result)
#         for i in range(4):
#             nx,ny = x+dx[i],y+dy[i]
#             if 0<=nx<r and 0<=ny<c:
#                 if array[nx][ny] not in al:
#                     q.add((nx,ny,al+array[nx][ny]))
# bfs(0,0)
# print(result)

# 2 4
# CAAB
# ADCB

# 3