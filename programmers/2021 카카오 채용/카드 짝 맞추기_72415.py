def solution(board, r, c):
    answer = int(1e9)
    dx,dy = [-1,0,1,0],[0,1,0,-1]
    visited = [[False] * 8]]
    def dfs(x,y,k,cnt):
        if board[x][y] == k:
            cnt+=1
        else:
            for i in range(4):
                nx,ny = x+dx[i],y+dy[i]
                
                dfs(nx,ny,board[nx][ny],cnt)    
        
    dfs(r,c,board[r][c],0)
        
    return answer

print(solution(	[[1, 0, 0, 3], [2, 0, 0, 0], [0, 0, 0, 2], [3, 0, 1, 0]], 1, 0))
print(solution([[3, 0, 0, 2], [0, 0, 1, 0], [0, 1, 0, 0], [2, 0, 0, 3]], 0, 1))