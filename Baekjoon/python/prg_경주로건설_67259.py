from collections import deque

dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(n,board):
    q = deque()

    d = [[[int(1e9)] * 4 for _ in range(n)] for _ in range(n)]
    d[0][0][1] = 0
    d[0][0][2] = 0
    q.append((0,1,0,0))
    q.append((0,2,0,0))
    
    while q:
        c,s,x,y = q.popleft()
        
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if not board[nx][ny]:
                    if i != s:
                        cost = c+600
                    else:
                        cost = c+100
                            
                    if cost <= d[nx][ny][s]:
                        d[nx][ny][s] = cost
                        q.append((cost,i,nx,ny))
    
    return min(d[-1][-1])
           
       

def solution(board):
    n = len(board)
    
    return bfs(n,board)


print(solution([[0, 0, 0, 0, 0, 0, 0, 0], [1, 0, 1, 1, 1, 1, 1, 0], [1, 0, 0, 1, 0, 0, 0, 0], [1, 1, 0, 0, 0, 1, 1, 1], [1, 1, 1, 1, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 0], [1, 1, 1, 1, 1, 1, 1, 0], [1, 1, 1, 1, 1, 1, 1, 0]]))
# print(solution([[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]))
# print(solution([[0, 0, 0, 0, 0, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 0, 1], [0, 0, 1, 0, 0, 0, 1, 0], [0, 1, 0, 0, 0, 1, 0, 0], [1, 0, 0, 0, 0, 0, 0, 0]]))