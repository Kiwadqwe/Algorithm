from collections import deque

dx,dy = [-1,0,1,0],[0,1,0,-1]
result = int(1e9)

def bfs(maps,n,m):
    global result
    
    q = deque()
    q.append((1,0,0))
    
    visited = [[False] * m for _ in range(n)]
    visited[0][0] = True

    while q:
        cnt,x,y = q.popleft()
        
        if x == n-1 and y == m-1:
            result = min(cnt,result)
        
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<n and 0<=ny<m:
                if not visited[nx][ny] and maps[nx][ny]:
                    visited[nx][ny] = True
                    q.append((cnt+1,nx,ny))
    
def solution(maps):
    global result
    
    n = len(maps)
    m = len(maps[0])
    
    bfs(maps,n,m)
    
    if result == int(1e9):
        return -1
    else:
        return result
    
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))