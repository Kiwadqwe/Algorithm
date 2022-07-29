from collections import deque

dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(k,x,y,places,visited):
    global dx,dy
    
    q = deque()
    q.append((0,x,y))
    visited[x][y] = True
    
    while q:
        cnt,x,y = q.popleft()
        
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            
            if 0<=nx<5 and 0<=ny<5:
                if not visited[nx][ny]:
                    if places[k][nx][ny] == "O":
                        visited[nx][ny] = True
                        q.append((cnt+1,nx,ny))
                    elif places[k][nx][ny] == "P":
                        if cnt < 2:
                            return False

    return True

def solution(places):
    result =  [1] * 5
    
    for i in range(5):
        check = True
        visited = [[False] * 5 for _ in range(5)]
        
        for j in range(5):
            for k in range(5):
                if not visited[j][k] and places[i][j][k] == "P":
                    if not bfs(i,j,k,places,visited):
                        check = False
                        break
                
            if not check:
                result[i] = 0
                break
            
    return result


print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))