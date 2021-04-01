import sys, heapq
input = sys.stdin.readline

n = int(input())
m = int(input())
INF = int(1e9)

array = [[] *(m+1) for _ in range(n+1)]
distance = [INF]*(n+1)

for i in range(m):
    a,b,c = map(int,input().split())
    array[a].append((b,c))
s,t = list(map(int,input().split()))

def dijkstra(s):
    q = []
    heapq.heappush(q,(0,s))
    distance[s] = 0
    
    while q:
        d,v = heapq.heappop(q)
        if distance[v] < d:
            continue
        for i in array[v]:
            cost = d+i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))
dijkstra(s)
print(distance[t])

# 5
# 8
# 1 2 2
# 1 3 3
# 1 4 1
# 1 5 10
# 2 4 2
# 3 4 1
# 3 5 1
# 4 5 3
# 1 5

# 4