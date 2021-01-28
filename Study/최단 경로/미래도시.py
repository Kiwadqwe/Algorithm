n, m = map(int,input().split())
INF = int(1e9)
# 2차원 리스트를 만들고 모든 값을 무한으로 초기화
graph =[[INF]* (n+1) for _ in range(n+1)]

for a in range(1,n+1):
    for b in range(1,n+1):
        if a==b:
            graph[a][b]=0

for _ in range(m):
    a,b = map(int,input().split())
    graph[a][b] = 1
    graph[b][a] =1
# k번 회사를 거쳐 x번 회사로 가는 최소 이동 시간
x,k= map(int,input().split())

# 모든 경로 저장
for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

distance = graph[1][k]+graph[k][x]

if distance >=INF:
    print("-1")
else:
    print(distance)