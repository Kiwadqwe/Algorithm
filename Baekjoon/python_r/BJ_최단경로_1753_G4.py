import sys,heapq
input = sys.stdin.readline

V,E = map(int,input().split())
K = int(input())
array = [[] for _ in range(V+1)]

for i in range(E):
    a,b,c = map(int,input().split())
    array[a].append((b,c))

d = [int(1e9)] * (V+1)

def dijkstra():
    q = []
    heapq.heappush(q,(0,K))
    d[K] = 0
    
    while q:
        cnt,x = heapq.heappop(q)
        
        if d[x] < cnt: continue
        
        for y,c in array[x]:
            cost = cnt+c
            
            if cost < d[y]:
                d[y] = cost
                heapq.heappush(q,(cost,y))
dijkstra()

for i in range(1,V+1):
    if d[i] == int(1e9):
        print("INF")
    else:
        print(d[i])