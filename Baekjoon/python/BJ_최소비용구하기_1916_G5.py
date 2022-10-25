import sys,heapq
input = sys.stdin.readline

N = int(input())
M = int(input())

array = [[] * (N+1) for _ in range(N+1)]

for _ in range(M):
    a,b,c = map(int,input().split())
    array[a].append((b,c))

A,B = map(int,input().split())

def dijkstra(A):
    q = []
    d = [int(1e9)] * (N+1)
    heapq.heappush(q,(0,A))

    while q:
        c,x = heapq.heappop(q)
        
        if x == B:
            return c
                
        if d[x] < c: continue
        
        for y,w in array[x]:
            cost = w+c
            
            if cost < d[y]:
                d[y] = cost
                heapq.heappush(q,(cost,y))

print(dijkstra(A))