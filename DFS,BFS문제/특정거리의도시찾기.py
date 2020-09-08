from collections import deque

n,m,k,x = map(int,input().split())

graph=[[] for _ in range(n+1)]

for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)

# 모든 도시에 대한 최단 거리 초기화
visited = [-1]* (n+1)
# 출발 도시까지의 거리 0
visited[x] =0
q=deque([x])

while q:
    v=q.popleft()
    # 현재 도시에서 이동할 수 있는 모든 도시를 확인
    for i in graph[v]:
        # 아직 방문하지 않은 도시라면
        if visited[i] == -1:
            visited[i]= visited[v]+1
            q.append(i)
# 최단 거리가 k인 모든 도시의 번호를 오름차순으로 출력
check = False
for i in range(1,n+1):
    if visited[i]==k:
        print(i)
        check=True

if check ==False:
    print("-1")
