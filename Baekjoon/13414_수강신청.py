import sys
input = sys.stdin.readline

k, l = map(int,input().split())
result = {}

for i in range(l):
    ipu = input().strip()
    result[ipu] = i

result = sorted(result, key = lambda x: result[x])

print('\n'.join(result[:k]))

# 3 8
# 20103324
# 20133221
# 20133221
# 20093778
# 20140101
# 01234567
# 20093778
# 20103325

# 20103324
# 20133221
# 20140101