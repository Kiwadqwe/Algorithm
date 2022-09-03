from collections import deque

def solution(m, n, board):
    answer = 0
    board = list(map(list,board))
    
    s = set()
    
    while True:

        for x in range(m-1):
            for y in range(n-1):
                if board[x][y] == board[x+1][y] == board[x][y+1] == board[x+1][y+1] != '0':
                    s |= set([(x,y),(x+1,y),(x,y+1),(x+1,y+1)])
        
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

print(solution(8,5,["HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK"]))