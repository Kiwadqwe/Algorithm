import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

TC = int(input())
result = {}

def dfs(v):
    if not visited[v]:
        visited[v] = True;
        dfs(array[v])
            
for t in range(TC):
    N = int(input())
    visited = [False] * (N+1)
    array = [0]+list(map(int,input().split()))
    cnt = 0

    for i in range(1,N+1):
        if not visited[i]:
            cnt+=1
            dfs(i)

    result[t] = cnt

for x,y in result.items():
    print(y)