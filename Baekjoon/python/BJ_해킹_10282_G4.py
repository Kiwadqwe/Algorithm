import sys,heapq
input = sys.stdin.readline

T = int(input())
        
def dijkstra(C):
    q = []
    heapq.heappush(q,(0,C))
    d = [int(1e9)] * (N+1)
    d[C] = 0
    while q:
        cost,x = heapq.heappop(q)
        
        if d[x] < cost: continue
        
        for y,w in array[x]:
            c = w+cost
            
            if c < d[y]:
                d[y] = c
                heapq.heappush(q,(c,y))
            
    return d

result = []
for _ in range(T):
    N,D,C = map(int,input().split())
    array = [[] for _ in range(N+1)]
    
    for i in range(D):
        a,b,c = map(int,input().split())
        
        array[b].append((a,c))
    
    d = dijkstra(C)
    inf = int(1e9)
    l = 0
    answer = 0
    for i in range(len(d)):
        if d[i] != inf:
            l+=1
            answer = max(answer,d[i])

    result.append((l,answer))
    
for x,y in result:
    print(x,y)