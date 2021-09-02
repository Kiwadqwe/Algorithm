import sys
input = sys.stdin.readline

n = int(input())
result = {}
for i in range(n):
    x,y = input().split()
    if y == 'enter':
        result[x] = 1
    else:
        del result[x]
        
result = sorted(result, reverse = True)
result = '\n'.join(result)

print(result)

# 4
# Baha enter
# Askar enter
# Baha leave
# Artem enter

# Askar
# Artem