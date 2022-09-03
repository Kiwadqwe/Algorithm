import sys
input = sys.stdin.readline

N = int(input())

array = [input().strip() for _ in range(N)]
array = list(set(array))
array = sorted(array, key = lambda x : (len(x),x))

print(*array,sep="\n")