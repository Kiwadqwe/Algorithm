import sys
input = sys.stdin.readline

s = input().strip()
n = int(input())
cnt = 0

for _ in range(n):
    a = input().strip()
    if s in a*2:
        cnt+=1

print(cnt)

# ABCD
# 3
# ABCDXXXXXX
# YYYYABCDXX
# DCBAZZZZZZ

# 2

# XYZ
# 1
# ZAAAAAAAXY

# 1