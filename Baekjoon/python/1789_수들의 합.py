import sys
input = sys.stdin.readline

s = int(input())

result,i = 0,0

while s>=0:
    i+=1
    s-=i
print(i-1)

# 200

# 19