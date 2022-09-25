answer = 0

def dfs(info,edges,sheep,wolf,visited):
    global answer
    
    if sheep <= wolf:
        return
    else:
        answer = max(answer,sheep)

    for x,y in edges:
        if visited[x] and not visited[y]:
            visited[y] = True
            if info[y] == 0:
                dfs(info,edges,sheep+1,wolf,visited)
                visited[y] = False
            else:
                dfs(info,edges,sheep,wolf+1,visited)
                visited[y] = False
        

def solution(info, edges):
    global answer
    visited = [False] * len(info)
    visited[0] = True
        
    dfs(info,edges,1,0,visited)    
    return answer

print(solution([0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1], [[0, 1], [1, 2], [1, 4], [0, 8], [8, 7], [9, 10], [9, 11], [4, 3], [6, 5], [4, 6], [8, 9]]))
print(solution([0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0], [[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6], [3, 7], [4, 8], [6, 9], [9, 10]]))