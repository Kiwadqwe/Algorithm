# import sys, heapq
# input = sys.stdin.readline

# N,M = map(int,input().split())
# array = [[] for _ in range(N+1)]
# d = [[0] * (N+1) for _ in range(N+1)]

# for _ in range(M):
#     x,y,z = map(int,input().split())
#     array[x].append((y,z))
#     array[y].append((x,z))

# def djikstra(start):
#     q = []
#     heapq.heappush(q,(0,start))
#     dp = [int(1e9) for i in range(N + 1)]

#     while q:
#         dist,x = heapq.heappop(q)

#         for y,w in array[x]:
#             cost = dist+w

#             if cost < dp[y]:
#                 dp[y] = cost
#                 d[y][start] = x
#                 heapq.heappush(q,(cost,y))

# for i in range(1,N+1):
#     djikstra(i)

# for i in range(1,N+1):
#     for j in range(1,N+1):
#         if i == j:
#             print("-",end=" ")
#         else:
#             print(d[i][j],end=" ")
#     print()

import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [[int(1e9)] * (N+1) for _ in range(N+1)]
d = [[j for j in range(N+1)] for _ in range(N+1)]

for i in range(1,N+1):
    array[i][i] = 0

for _ in range(M):
    x,y,z = map(int,input().split())
    array[x][y] = z
    array[y][x] = z

def flow():
    for k in range(1,N+1):
        d[k][k] = '-'
        for i in range(1,N+1):
            for j in range(1,N+1):
                if array[i][k]+array[k][j] < array[i][j]:
                    array[i][j] = array[i][k]+array[k][j]
                    d[i][j] = d[i][k]

flow()

for i in d[1:]:
    print(*i[1:])