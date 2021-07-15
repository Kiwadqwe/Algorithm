import sys
from collections import deque

input = sys.stdin.readline

n,m = map(int,input().split())

graph=[]

dx = [-1,0,1,0]
dy = [0,1,0,-1]

for _ in range(n):
    graph.append(list(map(int,input().strip())))

visited=[[False]*m for _ in range(n)]
cnt = [[0]*m for _ in range(n)]

visited[0][0]=True
cnt[0][0]=1


def bfs(x,y):
    q = deque()
    q.append((x,y))

    while q:
        x,y = q.popleft()
        # 네 방향 이동
        for i in range(4):
            mx,my = x+dx[i],y+dy[i]
            # 좌표를 벗어나지 않았을 때
            if 0<=mx<n and 0<=my<m:
                # 좌표의 값이 1이거나 방문한적이 없거나
                if graph[mx][my]==1 and visited[mx][my]==False:
                    visited[mx][my]=True
                    # 좌표 이동하면서 1++
                    cnt[mx][my]= cnt[x][y]+1
                    q.append((mx,my))

    return cnt[n-1][m-1]

print(bfs(0,0))

# 4 6
# 101111
# 101010
# 101011
# 111011

# 15

# 4 6
# 110110
# 110110
# 111111
# 111101

# 9