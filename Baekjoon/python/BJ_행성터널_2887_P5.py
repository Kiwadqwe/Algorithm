import sys
input = sys.stdin.readline

N = int(input())

x,y,z = [],[],[]

for i in range(1,N+1):
    a,b,c = map(int,input().split())
    x.append((a,i))
    y.append((b,i))
    z.append((c,i))

p = [i for i in range(N+1)]

def union(x,y):
    x = find(x)
    y = find(y)
    
    if x < y:
        p[y] = x
    else:
        p[x] = y
    
def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    return p[x]

result = 0

x.sort()
y.sort()
z.sort()

edge = []

for i in range(N-1):
    edge.append((x[i+1][0]-x[i][0],x[i][1],x[i+1][1]))
    edge.append((y[i+1][0]-y[i][0],y[i][1],y[i+1][1]))
    edge.append((z[i+1][0]-z[i][0],z[i][1],z[i+1][1]))

edge.sort()

for c,a,b in edge:
    if find(a) != find(b):
        union(a,b)
        result+=c
        
print(result)