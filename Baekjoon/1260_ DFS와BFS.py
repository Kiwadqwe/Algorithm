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

def bfs(graph, visited2, v):
    q = deque([v])
    visited2[v] = True  
    while q:
        v = q.popleft()
        print(v, end=' ')
        graph[v].sort()
        for i in graph[v]:
            if not visited2[i]:
                q.append(i)
                visited2[i] = True
                
dfs(graph, visited, v)
print(sep='\n')
bfs(graph, visited2, v)