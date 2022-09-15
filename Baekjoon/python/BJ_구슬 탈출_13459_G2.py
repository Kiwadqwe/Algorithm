import sys
from collections import deque

input = sys.stdin.readline

N,M = map(int,input().split())
array = [[''] * M for _ in range(N)]
X,Y,B_X,B_Y,R_X,R_Y = 0,0,0,0,0,0
dx,dy = [-1,0,1,0],[0,1,0,-1]

q = deque()

for i in range(N):
    ipu = input()
    for j in range(M):
        array[i][j] = ipu[j]
        if ipu[j] == 'B':
            B_X,B_Y = i,j
        elif ipu[j] == 'R':
            R_X,R_Y = i,j
            
visited = [[[[False] * 11 for _ in range(11)] for _ in range(11)] for _ in range(11)]
    
q.append((B_X,B_Y,R_X,R_Y,0))
visited[R_X][R_Y][B_X][B_Y] = True

def go(r_x,r_y,b_x,b_y,array,i):
    
    while True:
        b_nx,b_ny = b_x+dx[i],b_y+dy[i]
        r_nx,r_ny = r_x+dx[i],r_y+dy[i]
        
        if array[r_nx][r_ny] == '#' and array[b_nx][b_ny] == '#':
            return r_x,r_y,b_x,b_y
        
        if array[b_nx][b_ny] == 'O':
            print(0)
            sys.exit()
        elif array[b_nx][b_ny] != '#':
            b_x,b_y = b_nx,b_ny
        
        if array[r_nx][r_ny] == '0':
            print(1)
            sys.exit()
        elif array[r_nx][r_ny] == '.':
            r_x,r_y = r_nx,r_ny
        
        
        
def bfs():

    while q:
        b_x,b_y,r_x,r_y,cnt = q.popleft()
        
        if cnt == 10:
            return 0
        
        for i in range(4):
            r_nx,r_ny = r_x+dx[i],r_y+dy[i]
            if array[r_nx][r_ny] == '#': continue
            b_nx,b_ny,r_nx,r_ny = go(r_x,r_y,b_x,b_y,array,i)
        
            if not visited[r_nx][r_ny][b_nx][b_ny]:
                if array[r_nx][r_ny] == '.':
                    visited[r_nx][r_ny][b_nx][b_ny] = True
                    q.append((b_nx,b_ny,r_nx,r_ny,cnt))

    return 0
    
print(bfs())