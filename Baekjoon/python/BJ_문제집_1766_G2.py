import sys,heapq
input = sys.stdin.readline

N,M = map(int,input().split())
indegree = [0] * (N+1)
array = [[] for _ in range(N+1)]

for _ in range(M):
    a,b = map(int,input().split())
    array[a].append(b)
    indegree[b] += 1

result = []

def tolpology_sort_heapq():
    heap = []

    for i in range(1,N+1):
        if not indegree[i]:
            heapq.heappush(heap,i)
    
    while heap:
        now = heapq.heappop(heap)
        result.append(now)

        for arr in array[now]:
            indegree[arr] -= 1
            if not indegree[arr]:
                heapq.heappush(heap,arr) 

    for re in result:
        print(re, end= ' ')

tolpology_sort_heapq()