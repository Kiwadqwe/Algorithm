import sys
input = sys.stdin.readline

result = []
dp = [0] * 251
dp[0],dp[1],dp[2] = 1,1,3

while True:
    try:
        N = int(input())
        
        for i in range(3,N+1):
            dp[i] = (dp[i-1] + dp[i-2] * 2)

        result.append(dp[N])
    except:
        break
print(*result,sep = "\n")