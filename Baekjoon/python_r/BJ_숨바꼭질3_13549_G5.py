import sys,heapq
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())

def bfs():
    q = []
    heapq.heappush(q,(0,N))
    visited = [False] * 100001
    
    while q:
        cnt,x = heapq.heappop(q)
        
        if M == x:
            return cnt
        
        for i in (x*2,x+1,x-1):
            if 0<=i<=100000 and not visited[i]:
                if i == x*2:
                    heapq.heappush(q,(cnt,i))
                    visited[i] = True
                    continue
                visited[i] = True
                heapq.heappush(q,(cnt+1,i))

print(bfs())