import sys
input = sys.stdin.readline

N = int(input())

array = [list(map(int,input().split())) for _ in range(N)]
array.sort(key = lambda x : (x[1],x[0]))
s = array[0][1]
result = 1

for i in range(1,N):
    if s <= array[i][0]:
        result += 1
        s = array[i][1]
        
print(result)