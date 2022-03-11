import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())

sa = [0] * 201
for i in range(N):
    x,y = map(int,input().split())
    sa[x] = y

snake = [0] * 201
for i in range(M):
    x,y = map(int,input().split())
    snake[x] = y

visited = [False] * 201

def bfs():
    q = deque()
    q.append((1,0))
    
    while q:
        v,cnt = q.popleft()

        if v == 100:
            return cnt

        for i in range(1,7):
            vx = v+i
            if 100 < vx or visited[vx]: continue
                
            if sa[vx] != 0:
                vx = sa[vx]
            
            if snake[vx] != 0:
                vx = snake[vx]

            visited[vx] = True
            q.append((vx,cnt+1))    

print(bfs())