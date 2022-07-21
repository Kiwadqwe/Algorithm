import sys
input = sys.stdin.readline

N = int(input())
start,end,hap,cnt = 1,1,0,1

while start <= N // 2:
    
    if hap == N:
        hap -= start
        start+=1
        cnt+=1
    elif N < hap:
        hap -= start
        start+=1
    elif hap < N:
        hap += end
        end+=1
    
print(cnt)