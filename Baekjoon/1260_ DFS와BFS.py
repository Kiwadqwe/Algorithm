import sys
from collections import deque

input = sys.stdin.readline

n, m, v = map(int, input().split())

graph = [[] for i in range(n+1)]

visited = [False] * (n+1)
visited2 = [False] * (n+1)

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(graph, visited, v):
    visited[v] = True
    print(v, end=' ')
    graph[v].sort()
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, visited, i)

def bfs(graph, visited, v):
    q = deque([v])
    visited[v] = True  
    
    while q:
        v = q.popleft()
        print(v, end=' ')
        graph[v].sort()
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
                
dfs(graph, visited, v)
print(sep='\n')
bfs(graph, visited2, v)

# 4 5 1
# 1 2
# 1 3
# 1 4
# 2 4
# 3 4

# 5 5 3
# 5 4
# 5 2
# 1 2
# 3 4
# 3 1

# 1000 1 1000
# 999 1000