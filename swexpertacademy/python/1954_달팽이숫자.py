import sys
input = sys.stdin.readline

t = int(input())
dx = [-1,0,1,0]
dy = [0,1,0,-1]
cnt = 1

def dfs(x,y,cnt):
    for i in range(4):
        nx,ny = dx[i]+x,dy[i]+y
        if 0<=nx<n and 0<=ny<n:
            if not array[nx][ny]:
                array[nx][ny] = cnt
                dfs(nx,ny,cnt+1)

for tc in range(1,t+1):
    n = int(input())
    array = [[0] * n for _ in range(n)]
    array[0][0] = 1
    dfs(0,0,2)
    
    print("#"+str(tc))
    for arr in array:
        print(*arr)

# 2
# 3
# 4

#1
# 1 2 3
# 8 7 4
# 9 6 5
#2
# 1 2 3 4
# 16 11 10 5
# 15 12 9 6
# 14 13 8 7