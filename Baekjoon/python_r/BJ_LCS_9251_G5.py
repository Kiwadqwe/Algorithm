import sys
input = sys.stdin.readline

a = input().strip()
b = input().strip()

result = [[0] * (len(b)+1) for _ in range(len(a)+1)]

for i in range(1,len(a)+1):
    for j in range(1,len(b)+1):
        if a[i-1] == b[j-1]:
            result[i][j] = result[i-1][j-1]+1
        else:
            result[i][j] = max(result[i][j-1],result[i-1][j])

print(result[-1][-1])