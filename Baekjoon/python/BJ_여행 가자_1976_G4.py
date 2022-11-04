import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
p = [i for i in range(N)]

def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    return p[x]

def union(x,y):
    a = find(x)
    b = find(y)
    
    if a < b:
        p[b] = a
    else:
        p[a] = b
        
for i in range(N):
    array = list(map(int,input().split()))
    
    for j in range(N):
        if array[j] == 1:
            union(i,j)
            
array = list(map(int,input().split()))

for i in range(1,len(array)):
    if p[array[i-1]-1] != p[array[i]-1]:
        print("NO")
        sys.exit(0)
        
print("YES")