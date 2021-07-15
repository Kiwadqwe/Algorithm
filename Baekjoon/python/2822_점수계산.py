import sys
input = sys.stdin.readline

array = [int(input()) for _ in range(8)]
result =0
idx = []

for i in range(5):
    result += max(array)
    idx.append(array.index(max(array))+1)
    array[array.index(max(array))] = 0

idx.sort(reverse = False)
 
print(result)
print(*idx)

# 20
# 30
# 50
# 48
# 33
# 66
# 0
# 64

# 261
# 3 4 5 6 8