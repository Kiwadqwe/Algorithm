import sys
from itertools import combinations
input = sys.stdin.readline

N,M = map(int,input().split())
array = [[] for _ in range(N)]
chiken = []
home = []
cnt = 0

for i in range(N):
    ipu = list(map(int,input().split()))
    
    for j in range(N):
        a = ipu[j]
        array[i].append(a)
        
        if a == 2:
            chiken.append((i,j))
        elif a == 1:
            home.append((i,j))
            cnt+=1

result = int(1e9) 
for comb in combinations(chiken,M):
    check = [int(1e9)] * (cnt+1)
    for x,y in comb:
        for i in range(len(home)):
            a,b = home[i]
            temp = abs(a-x)+abs(b-y)
            check[i] = min(check[i],temp)
            
    result = min(sum(check[:cnt]),result)

print(result)