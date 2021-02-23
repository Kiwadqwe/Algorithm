import sys
from fractions import Fraction
input = sys.stdin.readline

n = int(input())
array = list(map(int,input().split()))
result = 0

for arr in array:
    arr = Fraction(arr)
    arr = Fraction(arr.denominator,arr.numerator)
    result += Fraction(arr)

re = Fraction(result)
print(Fraction(re.denominator,re.numerator))

# 3
# 4 1 2

# 4/7

# def printFraction(bunsu):
#     print ("%d/%d" % (bunsu[0], bunsu[1]))

# def gcd(a, b):
#     while (b != 0):
#         temp = a % b
#         a = b
#         b = temp
#     return abs(a)   

# def reduceFraction(bunja, bunmo):
#     frac = [ bunja, bunmo ]

#     if (frac[1] == 0): 
#         frac[0] = 0
#         frac[1] = 0
#         return frac

#     gcd_result = gcd(frac[0], frac[1])

#     frac[0] = frac[0] / gcd_result
#     frac[1] = frac[1] / gcd_result

#     return frac


# for arr in array:
#     result += 1/arr

# printFraction(reduceFraction(1,result))