import sys
input = sys.stdin.readline

n = int(input())
INF=int(1e9)
array=[[INF] *(n+1) for _ in range(n+1)]

while True:
    a,b = map(int,input().split())
    if a==-1 and b==-1:
        break
    array[a][b]=1
    array[b][a]=1

for i in range(1,n+1):
    array[i][i]=0

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if array[i][j] > array[i][k]+array[k][j]:
                array[i][j] = array[i][k]+array[k][j]
score = []

for i in range(1,n+1):
    score.append(max(array[i][1:]))

mi = min(score)
cnt = score.count(min(score))
print(mi,cnt)

for i in range(n):
    if mi==score[i]:
        print(i+1, end=' ')

# 5
# 1 2
# 2 3
# 3 4
# 4 5
# 2 4
# 5 3
# -1 -1

# 2 3
# 2 3 4