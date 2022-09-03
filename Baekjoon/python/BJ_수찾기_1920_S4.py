import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int,input().split()))
M = int(input())
array2 = list(map(int,input().split()))

array.sort()

result = []

for arr in array2:
    start,end = 0,N-1
    c = False
    
    while start <= end:
        m = (start+end)//2
        
        if array[m] == arr:
            c = True
            result.append(1)
            break
        elif array[m] < arr:
            start = m+1
        else:
            end = m-1     
    if not c:
        result.append(0)

print(*result,sep="\n")
    