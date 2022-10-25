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
        
        if A != B:
            if A < B:
                if not visited[A+A][B-A]:
                    q.append((A+A,B-A,C))
                    visited[A][B] = True
            else:
                if not visited[B+B][A-B]:
                    q.append((B+B,A-B,C))
                    visited[B+B][A-B] = True
                
        if A != C:
            if A < C:
                if not visited[A+A][C-A]:
                    q.append((A+A,C-A,B))
                    visited[A+A][C-A] = True
            else:
                if not visited[C+C][A-C]:
                    q.append((C+C,A-C,B))
                    visited[C+C][A-C] = True
                
        if B != C:
            if B < C:
                if not visited[B+B][C-B]:
                    q.append((B+B,C-B,A))
                    visited[B+B][C-B] = True
            else:
                if not visited[C+C][B-C]:
                    q.append((C+C,B-C,A))
                    visited[C+C][B-C] = True
    
    return 0

print(bfs(A,B,C))