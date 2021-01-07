import sys
input = sys.stdin.readline

n, k = map(int,input().split())
INF = int(1e9)
coin = []
array = [0]+[INF]*(k)

for _ in range(n):
    coin.append(int(input()))

for cn in coin:
    for i in range(cn,k+1):
        array[i] = min(array[i],array[i-cn]+1)

if array[k] != INF:
    print(array[k])
else:
    print(-1)       

# 3 15
# 1
# 5
# 12

# 3