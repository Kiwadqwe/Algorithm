# from functools import reduce
from fractions import Fraction
import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int,input().split()))

result = 0

# def mul(array):
#     return reduce(lambda x,y : x * y, array)

for i in range(n):
    result += Fraction(1,array[i])

print("%d/%d"%(Fraction(result).denominator,Fraction(result).numerator))

# 5 3 2

# 10