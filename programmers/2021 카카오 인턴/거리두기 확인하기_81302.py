from collections import deque
        
dx,dy = [-1,0,1,0],[0,1,0,-1]

def bfs(p,places,k):
    
    # 한사람씩 체크
    for j in range(len(p)):
        x,y = p.popleft()
        q = deque()
        q.append((0,x,y))
        visited = [[False] * 5 for _ in range(5)]
        visited[x][y] = True
        
        while q:
            cnt,x,y = q.popleft()
            
            for i in range(4):
                nx,ny = x+dx[i],y+dy[i]
                
                if 0<=nx<5 and 0<=ny<5:
                    if not visited[nx][ny]:
                        s = places[k][nx][ny]
                        if places[k][nx][ny] == 'O':
                            visited[nx][ny] = True
                            q.append((cnt+1,nx,ny))
                        elif places[k][nx][ny] == 'P':
                            if cnt < 2:
                                return False 
                            visited[nx][ny] = True               
    return True
            
def solution(places):
    answer = []
    for k in range(5):
        p = deque()
        
        for i in range(5):
            for j in range(5):
                if places[k][i][j] == 'P':
                    p.append((i,j))
        
        check = bfs(p,places,k)
        
        if not check:
            answer.append(0)
        else:
            answer.append(1)
            
    return answer

print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))