import sys
from math import factorial
input = sys.stdin.readline

t = int(input())
result = []

for _ in range(t):
    n,m = map(int,input().split())
    # n!/r!(n-r)!
    cm = int(factorial(m)/(factorial(n)*factorial(m-n)))
    result.append(cm)

for re in result:
    print(re)

# 3
# 2 2
# 1 5
# 13 29

# 3
# 2 2
# 1 5
# 13 29