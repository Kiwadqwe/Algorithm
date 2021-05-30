import sys
input = sys.stdin.readline

n = int(''.join(sorted(input().strip(),reverse = True)))

if n % 30 == 0:
    print(n)
else:
    print(-1)

# 2931

# -1

# 80875542

# 88755420