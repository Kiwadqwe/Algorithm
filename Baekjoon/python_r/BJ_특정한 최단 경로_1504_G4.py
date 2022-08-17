import sys,heapq
input = sys.stdin.readline

N,E = map(int,input().split())
array = [[] for _ in range(1+N)]

for _ in range(E):
    a,b,c = map(int,input().split())
    array[a].append((b,c))
    array[b].append((a,c))

R,C = map(int,input().split())

def dijkstra(x):
    q = []
    heapq.heappush(q,(0,x))
    d = [int(1e9)] * (N+1)
    d[x] = 0
    
    while q:
        c,x = heapq.heappop(q)
        
        for y,w in array[x]:
            cost = w+c
            
            if cost < d[y]:
                d[y] = cost
                heapq.heappush(q,(cost,y))
    return d

a = dijkstra(1)
r = dijkstra(R)
c = dijkstra(C)
result = min(a[R]+r[C]+c[N],a[C]+c[R]+r[N])

if int(1e9) <= result:
    print(-1)
else:
    print(result)

