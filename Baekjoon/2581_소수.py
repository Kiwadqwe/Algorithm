import sys
input = sys.stdin.readline

m = int(input())
n = int(input())
array = []

for i in range(m,n+1):
    if i == 2:
        array.append(i)
    for j in range(2,i):
        if i%j == 0 and i != j:
            break
        if j == i-1:
            array.append(i)

if len(array) == 0:
    print(-1)
else:
    print(sum(array))
    print(min(array))            

# 60
# 100

# 620
# 61

# 64
# 65

# -1