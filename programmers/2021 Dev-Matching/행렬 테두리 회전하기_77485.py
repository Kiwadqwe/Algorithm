def solution(rows, columns, queries):
    answer = []
    array = [[0]  * columns for _ in range(rows)]
    k = 1
    
    for i in range(rows):
        for j in range(columns):
            array[i][j] = k
            k+=1    

    for x,y,x2,y2 in queries:
        x,y,x2,y2 = x-1,y-1,x2-1,y2-1
        temp = array[x][y]
        m = temp
        
        for k in range(x,x2):
            t = array[k+1][y]
            array[k][y] = t
            m = min(m,t)
        
        for k in range(y,y2):
            t = array[x2][k+1]
            array[x2][k] = t
            m = min(m,t)
        
        for k in range(x2,x,-1):
            t = array[k-1][y2]
            array[k][y2] = t
            m = min(m,t)
        
        for k in range(y2,y,-1):
            t = array[x][k-1]
            array[x][k] = t
            m = min(m,t)
        
        array[x][y+1] = temp
        answer.append(m)

    
    return answer

print(solution(6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]))
print(solution(	3, 3, [[1, 1, 2, 2], [1, 2, 2, 3], [2, 1, 3, 2], [2, 2, 3, 3]]))
print(solution(100, 97, [[1, 1, 100, 97]]))