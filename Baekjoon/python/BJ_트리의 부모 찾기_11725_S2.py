import sys
sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline

N = int(input())
array = [[] for _ in range(N+1)]
visited = [False] * (N+1);
d = {}

for i in range(N-1):
    a,b = map(int,input().split())
    array[a].append(b)
    array[b].append(a)

def dfs(v):
    for i in array[v]:
        if not visited[i]:
            d[i] = v
            visited[i] = True
            dfs(i)

visited[1] = True;
dfs(1)

for i in range(2,N+1):
    print(d[i])