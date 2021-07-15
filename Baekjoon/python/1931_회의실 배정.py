import sys
input = sys.stdin.readline

n = int(input())
array = []

for i in range(n):
    a,b = map(int,input().split())
    array.append((a,b))

array = sorted(array, key = lambda x : (x[1],x[0]))
cnt = 0
start = 0

for a,b in array:
    if a >= start:
        start = b
        cnt+=1
print(cnt)

# 11
# 1 4
# 3 5
# 0 6
# 5 7
# 3 8
# 5 9
# 6 10
# 8 11
# 8 12
# 2 13
# 12 14

# 4