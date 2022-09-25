from collections import deque

def solution(m, n, board):
    answer = 0
    board = list(map(list,board))
    s = set()
    
    while True:
        for i in range(m-1):
            for j in range(n-1):
                if board[i][j] == board[i][j+1] == board[i+1][j] == board[i+1][j+1] != '0':
                    s |= set([(i,j),(i,j+1),(i+1,j),(i+1,j+1)])     
    
        if not len(s):
            break
        
        for x,y in s:
            board[x][y] = '0'
            answer+=1
        
        for i in range(n):
            q = deque()
            
            for j in range(m-1,-1,-1):
                if board[j][i] == '0':
                    q.append((j,i))
                else:
                    if q:
                        x,y = q.popleft()
                        board[x][y] = board[j][i]
                        board[j][i] = '0'
                        q.append((j,i))
            
        s.clear()        
    
    return answer

print(solution(	6, 6, ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]))