import sys
input = sys.stdin.readline

N,M,R = map(int,input().split())
item = [0]+list(map(int,input().split()))

array = [[int(1e9)] * (N+1) for _ in range(N+1)]

for i in range(N+1):
    array[i][i] = 0
    
for i in range(R):
    a,b,c = map(int,input().split())
    array[a][b] = c
    array[b][a] = c
    
for i in range(1,N+1):
    for j in range(1,N+1):
        for k in range(1,N+1):
            if array[i][j]+array[i][k] < array[j][k]:
                array[j][k] = array[i][j]+array[i][k]
result = 0
for i in range(1,N+1):
    hap = 0
    for j in range(1,N+1):
        if array[i][j] <= M:
            hap+=item[j]
    
    result = max(result,hap)

print(result)