import sys
input = sys.stdin.readline

N,M = map(int,input().split())
INF = int(1e9)
array = []
d = [INF] * (N+1)
d[1] = 0

for _ in range(M):
    a,b,c = map(int,input().split())
    array.append((a,b,c))

def bellman_ford():
    for i in range(N):
        for j in range(M):
            if d[array[j][0]] != INF and d[array[j][0]]+array[j][2] < d[array[j][1]]:
                d[array[j][1]] = d[array[j][0]]+array[j][2]

                if i == N-1:
                    return False
    return True

result = []
if not bellman_ford():
    print(-1)
else:
    for i in range(2,N+1):
        if d[i] == INF:
            result.append(-1)
        else:
            result.append(d[i])

    print(*result,sep="\n")