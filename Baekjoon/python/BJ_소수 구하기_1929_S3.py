import sys,math

input = sys.stdin.readline

M,N = map(int,input().split())
visited = [True] * 1000001
visited[1] = False

for i in range(2,int(math.sqrt(N))+1):
    if visited[i]:
        j = 2
        while i * j <= N:
            visited[i*j] = False
            j+=1

for i in range(M,N+1):
    if visited[i]:
        print(i)