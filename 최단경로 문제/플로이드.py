INF = int(1e9)
n = int(input())
m = int(input())

# 2차원 리스트를 만들고 모든 값들을 무한으로 초기화
graph = [[INF]*(n+1) for i in range(n+1)]

# 본인노드로 가는 거리는 0
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            graph[i][j] = 0

# 각 간선에 대한 정보 받고 초기화
for i in range(m):
    a, b, c = map(int, input().split())
    # 간선의 최단거리만 저장
    if c < graph[a][b]:
        graph[a][b] = c

# 점화식에 따라 플로이드 워셜 알고리즘 수행
for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == INF:
            print("0", end=" ")
        else:
            print(graph[i][j], end=" ")
    print()