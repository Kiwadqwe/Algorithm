import sys,heapq
input = sys.stdin.readline

N,M,X = map(int,input().split())

array = [[] * (N+1) for _ in range(N+1)]

for _ in range(M):
    a,b,c = map(int,input().split())
    array[a].append((b,c))

def dijkstra(n):
    d = [int(1e9)] *(N+1)
    q = []
    d[n] = 0
    heapq.heappush(q,(0,n))
    
    while q:
        c,x = heapq.heappop(q)

        if d[x] < c: continue
        
        for y,w in array[x]:
            cost = w+c
            
            if cost < d[y]:
                d[y] = cost
                heapq.heappush(q,(cost,y))
    return d        

dist = [[]]
for i in range(1,N+1):
    dist.append(dijkstra(i))

result = 0
for i in range(1,N+1):
    if int(1e9) <= dist[i][X]+dist[X][i]: continue
    result = max(result,dist[i][X]+dist[X][i])

print(result)