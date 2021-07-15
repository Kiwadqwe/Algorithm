import sys
input = sys.stdin.readline

n = int(input())

array = []

for _ in range(n):
    x,y = map(int,input().split())
    array.append((x,y))

array.sort(reverse = False)

for arr in array:
    print(*arr)

# 5
# 3 4
# 1 1
# 1 -1
# 2 2
# 3 3

# 1 -1
# 1 1
# 2 2
# 3 3
# 3 4