import sys, math
input = sys.stdin.readline

N = int(input())

prime = [True for i in range(N+1)]

for i in range(2,int(math.sqrt(N))+1):
    if prime[i]:
        for j in range(i*2, N+1, i):
            prime[j] = False
            
array = []
for x in range(2,N+1):
    if prime[x]: 
       array.append(x)

start,end,hap = 0,0,0
count = 0

while end <= len(array):
    hap = sum(array[start:end])
    if hap == N:
        end +=1
        count +=1
    elif N < hap:    
        start += 1
    elif hap < N:
        end += 1
        
print(count)