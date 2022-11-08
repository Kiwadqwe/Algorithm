import sys
input = sys.stdin.readline

T = int(input())

result = []

def get(x):
    if x != p[x]:
        p[x] = find(p[x])
        
    return p[x]

def union(x,y):
    a = get(x)
    b = get(y)
    
    if a != b:
        p[a] = b
        n[b]+=n[a]

def find(x):
    return get(x)

for _ in range(T):
    p = {}
    n = {}
    F = int(input())
    
    for i in range(F):
        x,y = map(str,input().split())
        
        if x not in p:
            p[x] = x
            n[x] = 1
        
        if y not in p:
            p[y] = y
            n[y] = 1
            
        union(x,y)
        result.append(n[find(p[x])])
        
print(*result,sep="\n")