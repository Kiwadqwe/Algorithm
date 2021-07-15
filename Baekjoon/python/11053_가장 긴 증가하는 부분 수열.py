import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))
dp = [1] * (n)

for i in range(1,n):
    for j in range(i):
        if array[i] > array[j]:
            dp[i] = max(dp[i],dp[j]+1)
        elif array[i] == array[j]:
            dp[i] = dp[j]

print(max(dp))

# 6
# 10 20 10 30 20 50

# 4