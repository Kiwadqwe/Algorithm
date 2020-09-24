import heapq
import sys

input = sys.stdin.readline
INF=int(1e9)
n,m = map(int,input().split())

array = [[] for i in range(n+1)]
distance = [INF]*(n+1)

for i in range(m):
    a,b = map(int,input().split())
    array[a].append((b,1))
    array[b].append((a,1))

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist,now = heapq.heappop(q)
        # 현재노드가 거친 노드면 무시
        if distance[now]<dist:
            continue
        # 현재 노드와 인접한 노드 확인
        for i in array[now]:
            cost = dist+i[1]
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))

dijkstra(1)

max_node=0
max_distance=0
result=[]

for i in range(1,n+1):
    if max_distance<distance[i]:
        max_node=i
        max_distance=distance[i]
        result =[max_node]
    elif max_distance==distance[i]:
        result.append(i)

print(max_node,max_distance,len(result))