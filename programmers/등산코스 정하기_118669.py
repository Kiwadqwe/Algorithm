import heapq

def dijkstra(array, gates, summits, dp):
    q = []
    
    for x in gates:
        heapq.heappush(q,(0,x))
        dp[x] = 0
    
    summits = set(summits)
    
    while q:
        c,x = heapq.heappop(q)
        
        if dp[x] < c or x in summits:
            continue
        
        for y,w in array[x]:
            # 봉우리까지의 경로별로 최대 비용 저장
            # 현재 위치에서 가장 큰 경로
            # 최대 비용중 최소값을 가진 등산로 선택
            m = max(c,w)
            if m < dp[y]:
                dp[y] = m
                heapq.heappush(q,(m,y))
    
def solution(n, paths, gates, summits):
        
    array = [[] for _ in range(n+1)]
    
    for x,y,z in paths:
        array[x].append((y,z))
        array[y].append((x,z))
        
    dp = [int(1e9)] * (n+1)
    
    dijkstra(array,gates,summits,dp)
    
    summits.sort(key = lambda x: (dp[x],x))

    return [summits[0], dp[summits[0]]]

print(solution(	7, [[1, 4, 4], [1, 6, 1], [1, 7, 3], [2, 5, 2], [3, 7, 4], [5, 6, 6]], [1], [2, 3, 4]))