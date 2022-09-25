from collections import deque

def solution(board, moves):
    answer = 0
    
    q = deque()
    r = len(board)
    
    for m in moves:
        m -= 1
        for i in range(r):
            if board[i][m]:
                if q and board[i][m] == q[-1]:
                    q.pop()
                    answer+=2
                else:
                    q.append(board[i][m])
                
                board[i][m] = 0
                break
    
    return answer


print(solution([[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]], [1, 5, 3, 5, 1, 2, 1, 4]))