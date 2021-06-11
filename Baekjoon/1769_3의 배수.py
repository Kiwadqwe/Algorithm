import sys
input = sys.stdin.readline

x = input().strip()

cnt = 0

while 1:
    if len(x) == 1:
        break
    x = str(sum(map(int,x)))
    cnt += 1

print(cnt)
print('YES' if int(x) % 3 ==0 else 'NO')

# 1234567

# 3
# NO