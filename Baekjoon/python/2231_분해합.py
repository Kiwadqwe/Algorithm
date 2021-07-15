import sys
input = sys.stdin.readline

n = int(input())
result = 0

for i in range(1,n+1):
    num = list(map(int,str(i)))
    result = i+sum(num)
    print(num)
    if n == result:
        print(i)
        break
    elif i == n:
        print(0)

# 216

# 198