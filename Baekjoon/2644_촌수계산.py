import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

a,b =map(int,input().split())

m = int(input())

graph=[[] for _ in range(n+1)]

for i in range(m):
    x,y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)

visited= [False] * (n+1)

def bfs(start,end):
    cnt=0
    # graph의 컬럼을 들렸을때만 cnt가 증가하기 위하여 q는 이중리스트를 사용
    q=deque([[start,cnt]])
    
    while q:
        value = q.popleft()
        v = value[0]
        cnt= value[1]
        if end==v:
            return cnt
        if not visited[v]:
            cnt+=1
            visited[v]=True
            for i in graph[v]:
                if not visited[i]:
                    q.append([i,cnt])
    return -1

print(bfs(a,b))

# 9
# 7 3
# 7
# 1 2
# 1 3
# 2 7
# 2 8
# 2 9
# 4 5
# 4 6