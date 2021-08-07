import sys
input = sys.stdin.readline

n = int(input())

def factorial(n):
    if n == 0:
        return 1
    if n == 1:
        return n
    
    return n * factorial(n-1)

print(factorial(n))

# 10

# 3628800