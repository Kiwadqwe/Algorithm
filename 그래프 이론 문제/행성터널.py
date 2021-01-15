import sys

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

input = sys.stdin.readline
n = int(input())
parent = [0] * (n+1)

graph = []

for i in range(1, n+1):
    parent[i] = i

edges = [list(map(int, input().split())) + [x] for x in range(n)]
edges.sort()

for i in range(n-1):
    graph.append((abs(edges[i][0]-edges[i+1][0]), edges[i][3], edges[i+1][3]))
edges.sort(key=lambda x: x[1])
for i in range(n-1):
    graph.append((abs(edges[i][1]-edges[i+1][1]), edges[i][3], edges[i+1][3]))
edges.sort(key=lambda x: x[2])
for i in range(n-1):
    graph.append((abs(edges[i][2]-edges[i+1][2]), edges[i][3], edges[i+1][3]))

graph.sort()
result = 0

for edge in graph:
    c, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += c
        
print(result)