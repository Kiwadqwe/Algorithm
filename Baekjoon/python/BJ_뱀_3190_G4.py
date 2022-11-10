import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
K = int(input())

apple =[]

for i in range(K):
    a,b = map(int,input().split())
    apple.append((a-1,b-1))

M = int(input())
move = {}
dx,dy = [-1,0,1,0],[0,1,0,-1]

for i in range(M):
    a,b = map(str,input().split())
    move[int(a)] = b

def bfs(d):
    q = deque()
    snake = deque()
    q.append((0,0,0))
    snake.append((0,0))
    
    while q:
        cnt,x,y = q.popleft()

        nx,ny = dx[d]+x,dy[d]+y
        
        if (nx < 0 or N-1 < nx or ny < 0 or N-1 < ny) or (nx,ny) in snake:
            return cnt+1
        
        if (nx,ny) not in apple:
            if snake:
                snake.popleft()
        else:
            apple.remove((nx,ny))
            
        q.append((cnt+1,nx,ny))
        snake.append((nx,ny))
        
        if cnt+1 in move.keys():
            if move[cnt+1] == 'L':
                if d == 0:
                    d = 3
                else:
                    d = (d-1) % 4
            else:
                d = (d+1) % 4
        
print(bfs(1))