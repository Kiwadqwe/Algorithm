n,m = map(int, input().split())

visited=[]
cnt=0

for i in range(n):
    visited.append(list(map(int,input())))
def dfs(x,y):
    if x<0 or x>=n or y<0 or y>=m:
        return False
    if visited[x][y]==0:
        visited[x][y]=1
        print(visited[x][y])
        #상하좌우 모두 재귀적으로 호출
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True

for i in range(n):
    for j in range(m):
        if dfs(i,j)==True:
            cnt+=1
print(cnt)

