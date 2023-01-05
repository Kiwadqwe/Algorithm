import sys
from collections import deque
input = sys.stdin.readline

F, S, G, U, D = map(int,input().split())

q = deque()
q.append((S,0))
visited = [False] * (F+1)

while q:
    s,cnt = q.popleft()
    
    if s == G:
        print(cnt)
        sys.exit(0)    

    if U and s+U<=F and not visited[s+U]:
        visited[s+U] = True
        q.append((s+U,cnt+1))
        
    if D and 1 <= s-D and not visited[s-D]:
        visited[s-D] = True
        q.append((s-D,cnt+1))

print("use the stairs")