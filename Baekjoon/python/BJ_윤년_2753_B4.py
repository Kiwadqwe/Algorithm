import sys
input = sys.stdin.readline

year = int(input())

# (4의 배수 and not 100의 배수) or 400배수
if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
    print(1)
else:
    print(0)