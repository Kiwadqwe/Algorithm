import sys
input = sys.stdin.readline

n = int(input())
array = set(map(int,input().split()))
# 딕셔너리
dis = {}

for arr in array:
    dis[arr] = 1

m = int(input())
array2 = list(map(int,input().split()))

for arr in array2:
    if arr in dis:
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