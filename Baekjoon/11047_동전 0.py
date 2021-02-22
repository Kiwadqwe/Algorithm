import sys
input = sys.stdin.readline

n,k = map(int,input().split())
array = [0]+[int(input()) for _ in range(n)]
result = 0

for i in range(n,0,-1):
    result += k//array[i]
    k = k % array[i]

print(result)

# 10 4200
# 1
# 5
# 10
# 50
# 100
# 500
# 1000
# 5000
# 10000
# 50000

# 6