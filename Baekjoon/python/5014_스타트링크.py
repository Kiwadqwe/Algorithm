import sys
from collections import deque
input = sys.stdin.readline

f, s, g, u, d = map(int, input().split())
dx=[u,d]

def bfs():
    q = deque([s])
    visited= [0]*(f+5)
    visited[s]=1
    # q가 비었을 때는 use the stairs를 출력해야함
    while q:
        v = q.popleft()
        # 원하는 층에 도착했을 때 방문한 횟수 출력
        if v==g:
            return visited[g]-1

        if 1<=v+u<=f and not visited[v+u]:
            visited[v+u]= visited[v]+1
            q.append(v+u)
        # v-d>0 인 이유는 
        if  v-d>0 and not visited[v-d]:
            visited[v-d]= visited[v]+1
            q.append(v-d)

    return 'use the stairs'

print(bfs())

# 10 1 10 2 1
# 6

# 100 2 1 1 0
# use the stairs