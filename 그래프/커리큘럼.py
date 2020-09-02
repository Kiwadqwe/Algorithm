from collections import deque
import copy

n = int(input())
indegree = [0]*(n+1)
graph = [[] for i in range(n+1)]
# 각 강의 시간을 0으로 초기화
time = [0] *(n+1)
for i in range(1,n+1):
    a = list(map(int,input().split()))
    # 첫 번째 수는 시간 정보를 담고 있음
    time[i] = a[0]
    for x in a[1:-1]:
        indegree[i]+=1
        graph[x].append(i)

def topology_sort():
    # 알고리즘 수행 결과를 담을 리스트
    result=copy.deepcopy(time)
    q=deque()
    for i in range(1,n+1):
        if indegree[i]==0:
            q.append(i)

    while q:
        now = q.popleft()
        for i in graph[now]:
            result[i]= max(result[i], result[now]+time[i])
            indegree[i]-=1
            if indegree[i] == 0:
                q.append(i)

    for i in range(1,n+1):
        print(result[i])

topology_sort()