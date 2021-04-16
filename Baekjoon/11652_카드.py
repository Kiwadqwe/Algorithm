import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
array = [int(input()) for _ in range(n)]
d = defaultdict(int)

for i in range(n):
    d[array[i]] +=1

result = sorted(d.items(), key = lambda x : (-x[1], x[0]))
print(result[0][0])

# 5
# 1
# 2
# 1
# 2
# 1

# 1