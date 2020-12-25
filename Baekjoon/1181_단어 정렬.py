import sys
input = sys.stdin.readline

n = int(input())

array = [] 

for _ in range(n):
    array.append((input().strip()))
# 중복 제거
array = list(set(array))
# 길이가 짧은 것부터, 길이가 같으면 사전 순으로
array.sort(reverse = False)
array.sort(key = len)
for arr in array:
    print(arr)

# 13
# but
# i
# wont
# hesitate
# no
# more
# no
# more
# it
# cannot
# wait
# im
# yours

# i
# im
# it
# no
# but
# more
# wait
# wont
# yours
# cannot
# hesitate