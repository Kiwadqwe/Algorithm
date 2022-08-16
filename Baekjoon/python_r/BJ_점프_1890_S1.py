import sys
input = sys.stdin.readline

N = int(input())
array = [list(map(int,input().split())) for _ in range(N)]

dx = [1,0]
dy = [0,1]
dp = [[0] * N for _ in range(N)]
dp[0][0] = 1

for i in range(N):
    for j in range(N):
        if dp[i][j] != 0 and array[i][j] != 0:
            if j+array[i][j] < N:
                dp[i][j+array[i][j]] += dp[i][j]
            if i+array[i][j] < N:
                dp[i+array[i][j]][j] += dp[i][j]
                
print(dp[N-1][N-1])