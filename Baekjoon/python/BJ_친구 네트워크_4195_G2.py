import sys
input = sys.stdin.readline

T = int(input())

def union(x,y):
    x = find(x)
    y = find(y)
    
    if x != y:
        p[x] = y
        f[y] += f[x]
        
def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    
    return p[x]

def friend_add(x,y):
    
    if x not in p:
        p[x] = x
        f[x] = 1

    if y not in p:
        p[y] = y
        f[y] = 1
        
result = []
for _ in range(T):
    F = int(input())
    array = [[] for _ in range(F+1)]
    p = {}
    f = {}

    for i in range(F):
        a,b = map(str,input().split())
        
        friend_add(a,b)
        union(a,b)

        result.append(f[find(a)])
        
print(*result, sep="\n")