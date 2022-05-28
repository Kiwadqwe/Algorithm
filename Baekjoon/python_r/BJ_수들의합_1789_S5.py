import sys
input = sys.stdin.readline

S = int(input())
sum = 0
N = 0

while 0<=S:
    N+=1
    S-=N

print(N-1)