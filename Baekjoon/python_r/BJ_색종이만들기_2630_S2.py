import sys
input = sys.stdin.readline

N = int(input())
array = [list(map(int,input().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
white = 0
blue =0

dx = [-1,0,1,0]
dy = [0,1,0,-1]

def go(x,y,N):
    global white,blue
    k = array[x][y]
    
    for i in range(x,x+N):
        for j in range(y,y+N):
            if k != array[i][j]:
                go(x,y,N//2)
                go(x,y+N//2,N//2)
                go(x+N//2,y,N//2)
                go(x+N//2,y+N//2,N//2)
                return
    if k == 0:
        white+=1
    else:
        blue+=1
        
go(0,0,N)      
print(white)
print(blue)