import sys,heapq,time

st = time.time()

input = sys.stdin.readline
N,M = map(int,input().split())
array = [[] for _ in range(N+1)]

for _ in range(M):
    x,y,z = map(int,input().split())
    array[x].append((y,z))
    array[y].append((x,z))

start,end = map(int,input().split())

def dijkstra(x):
    q = []
    
    heapq.heappush(q,(-int(1e9),x))
    d = [0] * (N+1)
    d[x] = int(1e9)
    
    while q:
        c,x = heapq.heappop(q)
        c = -c
        
        if end == x:
            return d[end]
        
        if c < d[x]: continue
        
        for y,w in array[x]:
            cost = min(w,d[x])
            
            if d[y] < cost:
                d[y] = cost
                heapq.heappush(q,(-cost,y))
                
print(dijkstra(start))