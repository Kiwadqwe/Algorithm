import sys

input = sys.stdin.readline

t = int(input())
result=[]

for _ in range(t):
    graph=[]
    n = int(input())
    for i in range(t):
        graph.append(list(map(int,input().split())))
    graph[1][1]+=graph[0][0]
    graph[0][1]+=graph[1][0]
    for i in range(2,n):
        graph[0][i]+=max(graph[1][i-2],graph[1][i-1])
        graph[1][i]+=max(graph[0][i-1],graph[0][i-2])
    result.append(max(graph[0][n-1],graph[1][n-1]))

for i in result:
    print(i)

# 2
# 5
# 50 10 100 20 40
# 30 50 70 10 60
# 7
# 10 30 10 50 100 20 40
# 20 40 30 50 60 20 80    

# 260
# 290