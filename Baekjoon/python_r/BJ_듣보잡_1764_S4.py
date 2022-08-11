import sys
input = sys.stdin.readline

N,M = map(int,input().split())
d = {input().strip() : 0 for _ in range(N)}
d2 = {input().strip() : 0 for _ in range(M)}

result = []

for dd in d:
    if dd in d2.keys():
        result.append(dd)

result.sort()
print(len(result))
print(*result, sep="\n")