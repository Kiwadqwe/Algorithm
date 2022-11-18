import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())
array = [[] for _ in range(N+1)]

s,e = 1,0
for _ in range(M):
    x,y,z = map(int,input().split())
    array[x].append((y,z))
    array[y].append((x,z))
    e+=z
    
start,end = map(int,input().split())
    
def bfs(m):
    q = deque()
    q.append((start))
    visited = [False] * (N+1)
    
    while q:
        x = q.popleft()
        
        for y,w in array[x]:
            if not visited[y] and m <= w:
                visited[y] = True
                q.append((y))
                
    return visited[end]

result = 0
while s <= e:
    m = (s+e)//2
    if bfs(m):
        result = max(result,m)
        s = m+1
    else:
        e = m-1

print(result)