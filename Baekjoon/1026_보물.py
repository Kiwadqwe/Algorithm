import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
s = 0
a.sort(reverse = False)
b.sort(reverse = True)

for i in range(n):
    s+=a[i]*b[i]
print(s)

# 5
# 1 1 1 6 0
# 2 7 8 3 1

# 18