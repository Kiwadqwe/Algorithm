import sys

n = int(input())
array = list(map(int,input().split()))

for arr in array:
    if arr == 1:
        n-=1
    for i in range(arr-1,1,-1):
        if arr%i == 0:
            n-=1
            break
print(n)

# 4
# 1 3 5 7

# 3