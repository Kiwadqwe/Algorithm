import sys
from collections import deque
input = sys.stdin.readline

X = int(input())

def bfs():
    q = deque()
    q.append((0,X))
    
    while q:
        cnt,x = q.popleft()
        if x == 1:
            return cnt
        
        if x%3 == 0:
            q.append((cnt+1,x//3))
        
        if x%2 == 0:
            q.append((cnt+1,x//2))
            
        q.append((cnt+1,x-1))

print(bfs())