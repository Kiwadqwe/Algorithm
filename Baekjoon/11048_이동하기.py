import sys
input = sys.stdin.readline

n,m = map(int,input().split())

graph = [[0]*n]
dp=[[0] *(m+1) for _ in range(n+1)]

for i in range(n):
    graph.append([0]+list(map(int,input().split())))

dp[1][1] =graph[1][1]

for i in range(1,n+1):
    for j in range(1,m+1):
        dp[i][j]=max(dp[i][j],dp[i-1][j]+graph[i][j],dp[i][j-1]+graph[i][j])
        
print(dp[n][m])

# 3 4
# 1 2 3 4
# 0 0 0 5
# 9 8 7 6

# 31

# 4 3
# 1 2 3
# 6 5 4
# 7 8 9
# 12 11 10

# 47