import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

array = [[int(1e9)] * (N+1) for _ in range(N+1)]

for i in range(1,N+1):
    array[i][i] = 0
    
for i in range(M):
    a,b,c = map(int,input().split())
    array[a][b] = min(c,array[a][b])
    
for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            array[i][j] = min(array[i][j],array[i][k]+array[k][j])

INF = int(1e9)
for i in range(1,N+1):
    for j in range(1,N+1):
        if array[i][j] == INF:
            array[i][j] = 0

for i in range(1,N+1):
    print(*array[i][1:])