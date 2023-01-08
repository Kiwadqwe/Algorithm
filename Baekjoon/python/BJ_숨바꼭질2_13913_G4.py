import sys
from collections import defaultdict, deque
input = sys.stdin.readline

N,K = map(int,input().split())

q = deque()
q.append((N,0))
visited = [False] * (100001)
d = defaultdict(int)

while q:
    x,time = q.popleft()
    if 100000 < x: continue
    
    visited[x] = True
    
    if x == K:
        d[time]+=1
    else:
        for i in (x-1,x+1,x*2):
            if 0<=i<=100000 and not visited[i]:
                q.append((i,time+1))

for x,y in d.items():
    print(x)
    print(y)
    sys.exit(0)