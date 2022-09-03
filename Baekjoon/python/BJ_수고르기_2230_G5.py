import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [int(input()) for _ in range(N)]

result = int(2e9)
start = 0
end = 1
array.sort()

while start < N and end < N:
    hap = array[end] - array[start]
    
    if hap == M:
        print(hap)
        exit(0)
    elif M < hap:
        result = min(result,hap)
        start+=1
    else:
        end+=1
    
print(result)