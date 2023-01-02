import sys
from itertools import permutations

input = sys.stdin.readline

N = int(input())
K = int(input())

array = [int(input()) for _ in range(N)]
result = []

for permu in permutations(array,K):
    p = ''.join(map(str,permu))
    if p not in result:
        result.append(p)
    
print(len(result))