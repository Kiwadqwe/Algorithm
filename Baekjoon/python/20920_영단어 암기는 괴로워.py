import sys
import collections
input = sys.stdin.readline

n, m = map(int,input().split())
array = []

for i in range(n):
    a = str(input().strip())
    if len(a) >= m:
        array.append(a)

cnt = collections.Counter(array)
counter = cnt.most_common()
result = sorted(counter, reverse = False, key = lambda x: (-x[1],-len(x[0]),x[0]))

for re in result:
    print(re[0])

# 12 5
# appearance
# append
# attendance
# swim
# swift
# swift
# swift
# mouse
# wallet
# mouse
# ice
# age

# swift
# mouse
# appearance
# attendance
# append
# wallet