import sys

input = sys.stdin.readline

n= int(input())
array=[]

for i in range(n):
    m = input()
    result=0
    quick=0
    for i in range(len(m)):
        if m[i]=='O':
            quick+=1
            result+=quick
        elif m[i]=='X':
            quick=0
    array.append(result)
for i in array:
    print(i)