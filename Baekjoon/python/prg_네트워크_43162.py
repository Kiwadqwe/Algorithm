def dfs(x,n,computers,visited):
    
    for i in range(n):
        if not visited[i] and computers[x][i]:
            visited[i] = True
            dfs(i,n,computers,visited)
    

def solution(n, computers):
    visited = [False] * n
    cnt = 0
    
    for i in range(n):
        if not visited[i]:
            if 2 <= computers[i].count(1):
                visited[i] = True
                dfs(i,n,computers,visited)
                
            cnt+=1
            
    return cnt

print(solution(3,[[1, 1, 0], [1, 1, 0], [0, 0, 1]]))