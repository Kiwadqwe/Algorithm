import sys
input = sys.stdin.readline

N = int(input())

array = [str(input()).strip() for _ in range(N)]

array.sort(key = lambda x : (len(x),sum([int(i) for i in x if i.isdigit()]),x))

for arr in array:
    print(arr)
    
# 5
# ABCD
# 145C
# A
# A910
# Z321

# A
# ABCD
# Z321
# 145C
# A910