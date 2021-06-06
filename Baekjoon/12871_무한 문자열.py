import sys
input = sys.stdin.readline

s = input().strip()
t = input().strip()

if s *len(t) == t * len(s):
    print(1)
else:
    print(0)

# ab
# abab

# 1

# abc
# bca

# 0