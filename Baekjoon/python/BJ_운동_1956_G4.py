import sys
input = sys.stdin.readline

N,E = map(int,input().split())

array = [[int(1e9)] * (N+1) for _ in range(N+1)]

for i in range(E):
    a,b,c = map(int,input().split())
    array[a][b] = c
    
for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            if  array[i][k]+array[k][j] < array[i][j]:
                array[i][j] = array[i][k]+array[k][j]
                
result = int(1e9)

# 싸이클을 도는 경로중에서 가장 작은 도로의 합
for i in range(1,N+1):
    result = min(result,array[i][i])

if int(1e9) <= result:
    print(-1)
else:
    print(result)