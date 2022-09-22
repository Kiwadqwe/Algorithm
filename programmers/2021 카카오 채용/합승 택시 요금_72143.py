import heapq

def solution(n, s, a, b, fares):
    answer = int(1e9)
    
    array = [[] for _ in range(n+1)]
    
    for x,y,z in fares:
        array[x].append((y,z))
        array[y].append((x,z))
    
    dp = [[int(1e9)] * (n+1) for _ in range(n+1)]
    
    def dijkstra(i):
        q = []
        heapq.heappush(q,(0,i))
        
        dp[i][i] = 0
        
        while q:
            cnt,x = heapq.heappop(q)
            
            if dp[i][x] < cnt: continue
            
            for y,w in array[x]:
                c = w+cnt
                
                if c < dp[i][y]:
                    dp[i][y] = c
                    heapq.heappush(q,(c,y))

    for i in range(1,n+1):
        dijkstra(i)
    
    for i in range(1,n+1):
        answer = min(answer, dp[i][a]+dp[i][b]+dp[s][i])
    
    return answer


print(solution(6, 4, 6, 2, [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]))

def solution(n, s, a, b, fares):
    answer = int(1e9)
    
    array = [[int(1e9)] * (n+1) for _ in range(n+1)]
    
    for i in range(1,n+1):
        array[i][i] = 0
    
    for x,y,z in fares:
        array[x][y] = z
        array[y][x] = z
          
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                if array[i][k]+array[k][j] < array[i][j]:
                    array[i][j] = array[k][j]+array[i][k]
    
    for i in range(1,n+1):
        answer = min(answer, array[i][a]+array[i][b]+array[s][i])
    
    return answer

print(solution(6, 4, 6, 2, [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]))
