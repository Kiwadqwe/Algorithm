import sys

input = sys.stdin.readline

t = int(input())

array=[]
dp=[1,2,4]

for i in range(t):
    n = int(input())
    array.append(n)

for i in range(3,11):
    dp.append(dp[i-1]+dp[i-2]+dp[i-3])
    
for i in array:
    print(dp[i-1])

# 3
# 4
# 7
# 10

# 7
# 44
# 274