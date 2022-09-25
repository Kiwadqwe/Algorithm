dx,dy = [-1,0,1,0],[0,1,0,-1]

def solution(board, skill):
    answer = 0
    temp = [[0] * (len(board[0])+1) for _ in range(len(board)+1)]
    
    for t,r1,c1,r2,c2,d in skill:
        if t == 1:
            temp[r1][c1] -= d
            temp[r1][c2+1] += d
            temp[r2+1][c1] += d
            temp[r2+1][c2+1] -= d
        elif t == 2:
            temp[r1][c1] += d
            temp[r1][c2+1] -= d
            temp[r2+1][c1] -= d
            temp[r2+1][c2+1] += d
    
    # 행
    for i in range(len(temp)-1):
        for j in range(len(temp[0])-1):
            temp[i][j+1] += temp[i][j]
    
    # 열
    for j in range(len(temp[0])-1):
        for i in range(len(temp)-1):
            temp[i+1][j] += temp[i][j]

    for x in range(len(board)):
        for y in range(len(board[0])):
            board[x][y] += temp[x][y]
            if 0 < board[x][y]:
                answer+=1

    return answer


print(solution([[5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5]], [[1, 0, 0, 3, 4, 4], [1, 2, 0, 2, 3, 2], [2, 1, 0, 3, 1, 2], [1, 0, 1, 3, 3, 1]]))
# print(solution([[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[1, 1, 1, 2, 2, 4], [1, 0, 0, 1, 1, 2], [2, 2, 0, 2, 0, 100]]))