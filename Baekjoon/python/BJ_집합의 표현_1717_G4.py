import sys
input = sys.stdin.readline

N,M = map(int,input().split())
p = [i for i in range(N+1)]
result = []

def union(x,y):
    x = find(x)
    y = find(y)
    
    if x != y:
        p[y] = x
        
def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    
    return p[x]    

for i in range(M):
    a,b,c = map(int,input().split())
    
    if not a:
        union(b,c)
    else:
        if find(b) != find(c):
            result.append("NO")
        else:
            result.append("YES")

print(*result,sep="\n")