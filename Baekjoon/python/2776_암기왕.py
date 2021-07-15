import sys
input = sys.stdin.readline

t = int(input())

for t in range(t):
    n = int(input())
    array = set(map(int,input().split()))
    m = int(input())
    array2 = list(map(int,input().split()))
    
    for i in range(len(array2)):
        if array2[i] in array:
            print(1)
        else:
            print(0)

# 1
# 5
# 4 1 5 2 3
# 5
# 1 3 7 9 5

# 1
# 1
# 0
# 0
# 1