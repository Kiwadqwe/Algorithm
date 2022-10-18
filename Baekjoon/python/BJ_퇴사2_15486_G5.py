import sys
input = sys.stdin.readline

N = int(input())
array = [list(map(int,input().split())) for _ in range(N)]
dp = [0] * (1+N)
m = 0

for i in range(N):
    m = max(m,dp[i])
    
    if array[i][0]+i <= N:
        dp[array[i][0]+i] = max(array[i][1]+m,dp[array[i][0]+i])
        print()

print(max(dp))