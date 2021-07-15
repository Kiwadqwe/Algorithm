import sys,heapq
input = sys.stdin.readline
INF = int(1e9)

v,e = map(int,input().split())
k = int(input())
array = [[] for _ in range(v+1)]
distance = [INF]*(v+1)

for _ in range(e):
    a,b,c = map(int,input().split())
    array[a].append((b,c))

def dijkstra(k):
    q = []
    heapq.heappush(q,(0,k))
    distance[k] = 0
    
    while q:
        dist,now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in array[now]:
            cost = dist+i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))

dijkstra(k)

for i in range(1,v+1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])

# 5 6
# 1
# 5 1 1
# 1 2 2
# 1 3 3
# 2 3 4
# 2 4 5
# 3 4 6

# 0
# 2
# 3
# 7
# INF