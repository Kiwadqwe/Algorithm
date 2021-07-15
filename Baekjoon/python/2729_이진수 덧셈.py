import sys
input = sys.stdin.readline

t = int(input())
array = []

for i in range(t):
    a,b = map(str,input().split())
    # 10진수로 변경
    a = int(a,2)
    b = int(b,2)
    # 2진수로 변경
    array.append(bin(a+b)[2:])

for arr in array:
    print(arr)

# 3
# 1001101 10010
# 1001001 11001
# 1000111 1010110

# 1011111
# 1100010
# 10011101