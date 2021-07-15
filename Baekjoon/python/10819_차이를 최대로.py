import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
array = list(map(int,input().split()))

pm = list(permutations(array,n))
result = 0

def cal(p):
    global result
    temp = 0
    for i in range(1,n):
        temp += abs(p[i]-p[i-1])
    result = max(result,temp)
    return result

for p in pm:
    cal(p)

print(result)

# 6
# 20 1 15 8 4 10

# 62