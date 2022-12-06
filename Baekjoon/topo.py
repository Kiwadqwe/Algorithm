import sys,heapq

input = sys.stdin.readline

N,M = map(int,input().split())
indegree = [0] * (N+1)
array = [[] for _ in range(N+1)]

for _ in range(M):
    a,b = map(int,input().split())
    array[a].append(b)
    indegree[b]+=1
    
result = []

def tolpology_sort_heapq():
    q = []
    
    for i in range(1,N+1):
        if not indegree[i]:
            heapq.heappush(q,i)
    
    while q:
        n = heapq.heappop(q)
        
        result.append(n)
        
        for a in array[n]:
            indegree[a]-=1
            if not indegree[a]:
                heapq.heappush(q,a)
    
tolpology_sort_heapq()

print(*result)