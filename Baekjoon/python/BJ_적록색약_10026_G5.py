import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

N = int(input())
array = [list(map(str,input().strip())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]
cnt = 0

def dfs(x,y,color):
    for i in range(4):
        nx,ny = x+dx[i],y+dy[i]
        if nx<0 or N<=nx or ny<0 or N<=ny: continue

        if not visited[nx][ny] and array[nx][ny] == color:
            visited[nx][ny] = True
            if array[nx][ny] == 'G': array[nx][ny] = 'R'
            dfs(nx,ny,color)

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            cnt+=1
            dfs(i,j,array[i][j])
            if array[i][j] == 'G': array[i][j] = 'R'

cnt2 = 0 
visited = [[False] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            cnt2+=1
            dfs(i,j,array[i][j])

print(cnt,cnt2)