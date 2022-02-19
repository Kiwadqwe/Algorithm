import sys
input = sys.stdin.readline


N = int(input())
array = [0]+list(map(int,input().split()))
dp = [0] * (N+1)

for i in range(1,N+1):
    for j in range(i):
        if array[j] < array[i]:
            dp[i] = max(dp[i],dp[j]+1)
        elif array[i] == array[j]:
            dp[i] = dp[j]

print(max(dp))