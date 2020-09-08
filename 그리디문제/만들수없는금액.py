n= int(input())

ipu = list(map(int,input().split()))
ipu.sort()
target=1
for x in ipu:
    if target<x:
        break
    target+=x
print(target)