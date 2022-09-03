import sys
input = sys.stdin.readline

N,S = map(int,input().split())
array = list(map(int,input().split()))

start,end,hap,cnt = 0,0,0,int(1e9)

while start < N:

    if S <= hap:
        cnt = min(cnt,end-start)
        hap -= array[start]
        start+=1
    elif end < N:
        hap += array[end]
        end+=1
    else:
        hap -= array[start]
        start+=1

if cnt == int(1e9):
    print(0)
else:
    print(cnt)