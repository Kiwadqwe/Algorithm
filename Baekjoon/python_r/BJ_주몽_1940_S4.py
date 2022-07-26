import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
array = list(map(int,input().split()))

array.sort()
start,end,hap,cnt = 0,len(array)-1,0,0

while start < end:
    hap = array[start]+array[end]
    if hap == M:
        cnt+=1
        end-=1
        start+=1
    elif M < hap:
        end-=1
    else:
        start+=1
        
print(cnt)