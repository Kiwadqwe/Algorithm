import sys
from itertools import combinations
input = sys.stdin.readline

N,S = map(int,input().split())

array = list(map(int,input().split()))
result = 0

for i in range(1,N+1):
    for comb in combinations(array,i):
        hap = sum(comb)
        
        if hap == S:
            result+=1
            
print(result)