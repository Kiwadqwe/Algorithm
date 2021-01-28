import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)
dx = [-1,0,1,0]
dy = [0,1,0,-1]

result=[]

for i in range(int(input())):
    t = int(input())
    array=[]
    for j in range(t):
        array.append(list(map(int,input().split())))

    distance=[[INF]*t for _ in range(t)]

    x,y=0,0

    q=[(array[x][y],x,y)]
    distance[x][y]=array[x][y]

    while q:
        dist,x,y=heapq.heappop(q)
        # 처리된 노드라면 무시
        if distance[x][y]<dist:
            continue
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx <0 or ny<0 or nx>=t or ny>=t:
                continue
            cost = array[nx][ny]+dist
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost<distance[nx][ny]:
                distance[nx][ny]=cost
                heapq.heappush(q,(cost,nx,ny))

    result.append(distance[t-1][t-1])
for i in result:
    print(i)