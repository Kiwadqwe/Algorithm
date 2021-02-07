import sys
input = sys.stdin.readline

n = int(input())
array = [list(map(int,input().split())) for _ in range(n)]

for k in range(n):
    for i in range(n):
        for j in range(n):
            if array[i][k] == 1 and array[k][j] == 1:
                array[i][j] = 1

for arr in array:
    print(*arr)

# 7
# 0 0 0 1 0 0 0
# 0 0 0 0 0 0 1
# 0 0 0 0 0 0 0
# 0 0 0 0 1 1 0
# 1 0 0 0 0 0 0
# 0 0 0 0 0 0 1
# 0 0 1 0 0 0 0

# 1 0 1 1 1 1 1
# 0 0 1 0 0 0 1
# 0 0 0 0 0 0 0
# 1 0 1 1 1 1 1
# 1 0 1 1 1 1 1
# 0 0 1 0 0 0 1
# 0 0 1 0 0 0 0