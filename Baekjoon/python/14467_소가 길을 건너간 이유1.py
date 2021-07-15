import sys
input = sys.stdin.readline

n = int(input())
array =[-1] * 11
tp = [-1] * 11

for i in range(n):
    a,b = map(int,input().split())
    if array[a] != b :
        array[a] = b
        tp[a] +=1

result = 0

for t in tp:
    if t >=1:
        result +=t

print(result)

# 8
# 3 1
# 3 0
# 6 0
# 2 1
# 4 1
# 3 0
# 4 0
# 3 1

# 3