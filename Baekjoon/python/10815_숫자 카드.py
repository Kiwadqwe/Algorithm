import sys
input = sys.stdin.readline

n = int(input())
array = set(map(int,input().split()))
m = int(input())
card = list(map(int,input().split()))

check=0

for car in card:
    if car in array:
        check = 1
        print(check, end= ' ')
    else:
        check = 0
        print(check, end= ' ')

# 5
# 6 3 2 10 -10
# 8
# 10 9 -5 2 3 4 5 -10

# 1 0 0 1 1 0 0 1