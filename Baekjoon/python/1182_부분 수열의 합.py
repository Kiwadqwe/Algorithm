import sys
from itertools import combinations
input = sys.stdin.readline

n,s = map(int,input().split())
array = list(map(int,input().split()))
cnt =0

for i in range(1,len(array)+1):
    cb = combinations(array,i)
    for c in cb:
        result = sum(c)
        if result == s:
            cnt += 1

print(cnt)

# 5 0
# -7 -3 -2 5 8

# 1