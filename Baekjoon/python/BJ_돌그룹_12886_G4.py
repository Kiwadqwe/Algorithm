import sys
from collections import deque
input = sys.stdin.readline

A,B,C = map(int,input().split())

def bfs(A,B,C):
    q = deque()
    l = A+B+C
    visited = [[False] * l for _ in range(l)]
    q.append((A,B,C))
    visited[A][B] = True
    
    while q:
        A,B,C = q.popleft()
        if A == B == C:
            return 1
        
        for i,j in (A,B),(A,C),(B,C):
            if i < j:
                if not visited[i+i][j-i]:
                    q.append((i+i,j-i,l-(i+j)))
                    visited[i+i][j-i] = True
            if j < i:
                if not visited[j+j][i-j]:
                    q.append((j+j,i-j,l-(i+j)))
                    visited[j+j][i-j] = True
         
    return 0

print(bfs(A,B,C))