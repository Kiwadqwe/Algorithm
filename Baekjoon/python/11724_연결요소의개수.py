import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

visited = [False]*(n+1)
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start):
    q = deque([start])
    visited[start] = True

    while q:
        v = q.popleft()
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                q.append(i)

cnt=0

for i in range(1,n+1):
    if not visited[i]:
        bfs(i)
        cnt+=1
print(cnt)

# 6 5
# 1 2
# 2 5
# 5 1
# 3 4
# 4 6

# 1