import sys
input =sys.stdin.readline

n = int(input())
array = [0]+list(map(int,input().split()))
dp=[0]*(n+1)

for i in range(1,n+1):
    for j in range(1,i+1):
        dp[i]=max(dp[i],dp[i-j]+array[j])
    
print(dp[n])

# 4
# 1 5 6 7

# 10

# 4
# 3 5 15 16

# 18