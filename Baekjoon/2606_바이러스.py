import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

graph= []
virus=[False]*(n+1)

graph=[[] for _ in range(n+1)]
for i in range(int(input())):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(graph,start,virus):
    q=deque([start])
    virus[start]=True

    while q:
        v=q.popleft()
        for i in graph[v]:
            if not virus[i]:
                q.append(i)
                virus[i]=True
                
bfs(graph,1,virus)
cnt=0
for i in virus:
    if i==True:
        cnt+=1

print(cnt-1)
# 7
# 6
# 1 2
# 2 3
# 1 5
# 5 2
# 5 6
# 4 7

# 4