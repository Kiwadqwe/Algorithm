import sys
from collections import deque
input = sys.stdin.readline

V,E = map(int,input().split())
indegree = [0] * (V+1)
array = [[] for _ in range(V+1)]

for _ in range(E):
    a,b = map(int,input().split())
    array[a].append(b)
    # 진입차수 추가
    indegree[b] += 1

def topology_sort():
    result = []

    q = deque()

    for i in range(1,V+1):
        if not indegree[i]:
            q.append(i)

    while q:
        now = q.popleft()
        # 결과 값
        result.append(now)

        # 해당 원소와 연결된 노드들의 진입차수에서 1빼기
        for arr in array[now]:
            indegree[arr] -= 1
            if not indegree[arr]:
                q.append(arr)

    for re in result:
        print(re, end= ' ')
    
topology_sort()
# sample input
# 7 8
# 1 2
# 1 5
# 2 3
# 2 6
# 3 4
# 4 7
# 5 6
# 6 4