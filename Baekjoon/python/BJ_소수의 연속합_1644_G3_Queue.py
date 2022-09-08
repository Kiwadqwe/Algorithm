import sys, math
from collections import deque
input = sys.stdin.readline

N = int(input())

prime = [True for i in range(N+1)]

for i in range(2,int(math.sqrt(N))+1):
    if prime[i]:
        for j in range(i*2, N+1, i):
            prime[j] = False
       
q = deque()
hap,count = 0,0

for i in range(N,1,-1):
    if not prime[i]: continue
    
    hap += i
    q.append(i)
    
    if hap == N:
        count +=1
    
    while q and N < hap:
        x = q.popleft()
        hap -= x
        
        if hap == N: 
            count+=1
    
print(count)