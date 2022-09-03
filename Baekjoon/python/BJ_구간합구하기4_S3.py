import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = list(map(int,input().split()))
dp = [0] * (N+1)

for i in range(N):
    dp[i+1] = dp[i] + array[i]

result = []
for _ in range(M):
    a,b = map(int,input().split())
    result.append(dp[b]-dp[a-1])
    
print(*result,sep="\n")