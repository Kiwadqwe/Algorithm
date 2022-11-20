import sys,heapq
input = sys.stdin.readline

N,M = map(int,input().split())
array = [[] for _ in range(N+1)]
q = []

for _ in range(M):
    x,y,z = map(int,input().split())
    heapq.heappush(q,(-z,x,y))
    heapq.heappush(q,(-z,y,x))
    
p = [i for i in range(N+1)]
    
start,end = map(int,input().split())

def union(x,y):
    x = find(x)
    y = find(y)
    
    if x < y:
        p[y] = x
    else:
        p[x] = y

def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    
    return p[x]

while q:
    z,x,y = heapq.heappop(q)
    z = -z
    
    union(x,y)
    
    if find(start) == find(end):
        print(z)
        sys.exit(0)
