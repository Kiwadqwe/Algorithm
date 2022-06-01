import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

N,M,K = map(int,input().split())
visited = [[False] * M for _ in range(N)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

for i in range(K):
    y,x,y2,x2 = map(int,input().split())

    for i in range(x,x2):
        for j in range(y,y2):
            visited[i][j] = True

def dfs(x,y):
    global cnt

    for i in range(4):
        nx,ny = x+dx[i],y+dy[i]

        if 0<=nx<N and 0<=ny<M:
            if not visited[nx][ny]:
                visited[nx][ny] = True
                cnt+=1
                dfs(nx,ny)
cnt = 0
result = []
area = 0
for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            cnt = 1
            area += 1
            visited[i][j] = True
            dfs(i,j)
            result.append(cnt)

print(area)
print(' '.join(map(str,sorted(result))))