import sys

input = sys.stdin.readline

n=int(input())
array=[]
for i in range(n):
    m = input()
    m = m[0].upper()+m[1:-1]
    array.append(m)
for i in array:
    print(i)