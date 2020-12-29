import sys
from collections import deque
input = sys.stdin.readline

n,k = map(int,input().split())
visited = [False] *(100001)
cnt = 0

def bfs(n,k):
    global cnt
    q = deque()
    q.append((n,cnt))
    while q:
        v,cnt = q.popleft()
        if v == k:
            return cnt
        if not visited[v]:
            visited[v] = True
            for i in (v-1,v+1,v*2):
                if 0<=i<=100000:
                    q.append((i,cnt+1))
    # while q:
    #     v,cnt = q.popleft()
    #     if v == k:
    #         return cnt
    #     if not visited[v]:
    #         visited[v] = True
    #         if v-1>=0:
    #             q.append((v-1,cnt+1))
    #         if v+1<=100000:
    #             q.append((v+1,cnt+1))
    #         if v*2<=100000:
    #             q.append((v*2,cnt+1))     
               
print(bfs(n,k))

# 5 17

# 4