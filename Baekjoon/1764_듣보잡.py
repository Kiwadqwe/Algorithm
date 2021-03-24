import sys,collections
input = sys.stdin.readline

n,m = map(int,input().split())
array = [input().strip() for _ in range(n+m)]
result = []
d = collections.Counter(array)

for x,y in d.items():
    if y >= 2:
        result.append(x)

result.sort()

print(len(result))
print('\n'.join(result))

# 3 4
# ohhenrie
# charlie
# baesangwook
# obama
# baesangwook
# ohhenrie
# clinton

# 2
# baesangwook
# ohhenrie