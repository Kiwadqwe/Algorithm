import heapq

def dijkstra(n, array, gates, summits,dp):
    q = []
    for x in gates:
        heapq.heappush(q,(0,x))
        dp[x] = 0

    while q:
        c,x = heapq.heappop(q)
        
        if c < dp[x] or x in summits:
            continue
        
        for y,w in array[x]:
            # 봉우리까지의 경로별로 최대 비용 저장
            # 현재 위치(x)에서 목적지(y)까지 가장 큰 비용
            m = max(dp[x],w)
            if m < dp[y]:
                dp[y] = m
                heapq.heappush(q,(m,y))
    
def solution(n, paths, gates, summits):
        
    array = [[] for _ in range(n+1)]
    
    for x,y,z in paths:
        array[x].append((y,z))
        array[y].append((x,z))
        
    dp = [int(1e9) for _ in range(n+1)]

    dijkstra(n,array, gates, summits,dp)
    
    intensity,result = int(1e9),0
    for s in summits:
        # 최대 비용중 최소값을 가진 등산로 선택
        if dp[s] < intensity:
            intensity = dp[s]
            result = s 
            
    return [result,intensity]

print(solution(	7, [[1, 4, 4], [1, 6, 1], [1, 7, 3], [2, 5, 2], [3, 7, 4], [5, 6, 6]], [1], [2, 3, 4]))