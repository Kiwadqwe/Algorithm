import sys
from collections import deque
input = sys.stdin.readline

N,M = map(int,input().split())
array = [[] for _ in range(N+1)]
idg = [0] * (N+1)

for _ in range(M):
    a = list(map(int,input().split()))[1:]
    for i in range(len(a)-1):
        array[a[i]].append(a[i+1])
        idg[a[i+1]] +=1

result = []
def topology_sort():
    q = deque()

    for i in range(1,N+1):
        if not idg[i]:
            q.append(i)
            
    while q:
        x = q.popleft()
        
        result.append(x)
        
        for a in array[x]:
            idg[a] -= 1
            if not idg[a]:
                q.append(a)

topology_sort()

if len(result) == N:
    print(*result, sep="\n")
else:
    print(0)