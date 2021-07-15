import sys
input = sys.stdin.readline

n = int(input())
array = set(map(int,input().split()))

m = int(input())
target = list(map(int,input().split()))

for t in target:
    if t in array:
        print('1')
    else:
        print('0')

# 5
# 4 1 5 2 3
# 5
# 1 3 7 9 5

# 1
# 1
# 0
# 0
# 1