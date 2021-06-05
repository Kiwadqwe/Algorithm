import sys
input = sys.stdin.readline

result = []

while True:
    n = int(input())
    array =[]
    if n == 0:
        break
    
    for i in range(n):
        s = input().strip()
        array.append(s)
    array = sorted(array, key = lambda x : x.upper())
    result.append(array[0])

for re in result:
    print(re)

# 3
# Cat
# fat
# bAt
# 4
# call
# ball
# All
# Hall
# 0

# bAt
# All