import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

graph=[]

dx=[-1,0,1,0]
dy=[0,1,0,-1]

for i in range(n):
    graph.append(list(map(int,input().strip())))

visited = [[False]*n for _ in range(n)]
array=[]
count=0

def bfs(x,y):
    q=deque()
    q.append((x,y))
    graph[x][y]=0
    cnt=1

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if graph[nx][ny]==1 and not visited[nx][ny]:
                    # 방문한곳은 True와 0번 넣음
                    visited[nx][ny]=True
                    graph[nx][ny]=0
                    cnt+=1
                    q.append((nx,ny))
    return cnt

# 한번 돌고 다시 돌아야 함
for i in range(n):
    for j in range(n):
        if not visited[i][j] and graph[i][j]==1:
            array.append(bfs(i,j))

print(len(array))

# 오름차순으로 출력
for i in sorted(array):
    print(i)

# 7
# 0110100
# 0110101
# 1110101
# 0000111
# 0100000
# 0111110
# 0111000

# 3
# 7
# 8
# 9