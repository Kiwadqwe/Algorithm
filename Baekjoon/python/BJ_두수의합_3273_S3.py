import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int,input().split()))
X = int(input())
start,end,hap,cnt=0,len(array)-1,0,0
array.sort()

while start < end:
    hap = array[end]+array[start]
    if hap == X:
        end-=1
        start+=1
        cnt+=1
    elif X < hap:
        end-=1
    else:
        start+=1

print(cnt)
