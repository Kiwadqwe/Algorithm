import sys
input = sys.stdin.readline

N,M,H = map(int,input().split())

dp = [[1]+[0] * H for _ in range(N+1)]

for i in range(1,N+1):
    dp[i] = dp[i-1].copy()
    array = list(map(int,input().split()))
    for j in array:
        for k in range(j,H+1):
            dp[i][k]+=dp[i-1][k-j]

print(dp[N][H] % 10007)