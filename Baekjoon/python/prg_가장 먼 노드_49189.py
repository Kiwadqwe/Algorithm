from collections import deque

def bfs(n,array):
    q = deque()
    visited = [False] * (n+1)
    q.append((0,1))
    result = []
    visited[1] = True
    
    while q:
        cnt,x = q.popleft()
        
        result.append(cnt)
        
        for y in array[x]:
            if not visited[y]:
                visited[y] = True
                q.append((cnt+1,y))
                
    return result

def solution(n, edge):
    answer = 0
    array = [[] for _ in range(n+1)]
    
    for i in range(len(edge)):
        array[edge[i][0]].append(edge[i][1])
        array[edge[i][1]].append(edge[i][0])
        
    result = bfs(n,array)
    answer = result.count(max(result))
    
    return answer

print(solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))