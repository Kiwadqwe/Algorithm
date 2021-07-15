import sys
input = sys.stdin.readline

result = []

s = input().strip()
t = input().strip()

# 1
cnt = 0
j = 0

while True:
    if j >len(s):
        break
    if s[j:len(t)+j] == t:
        cnt+=1
        j+=len(t)
    else:
        j+=1

print(cnt)

# 2
# print(s.count(t))

# ababababa
# aba

# 2