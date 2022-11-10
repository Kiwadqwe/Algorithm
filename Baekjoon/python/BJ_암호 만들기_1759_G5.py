import sys
from itertools import combinations

input = sys.stdin.readline

L,C = map(int,input().split())
array = list(map(str,input().split()))
result = []
alpha = ('a','e','i','o','u')
array.sort()

combs = combinations(array,L)

for comb in combs:
    hap = 0

    for a in alpha:
        if a in comb:
            hap+=1
    
    if 1 <= hap and 2 <= L-hap:    
        result.append(''.join(comb))

print(*result, sep="\n")