import sys
input = sys.stdin.readline

T = int(input())
result = []

def lca(x,y):
    d_x,d_y = [],[]
    
    while x != 0:
        d_x.append(x)
        x = p[x]
        
    while y != 0:
        d_y.append(y)
        y = p[y]
    
    for i in range(len(d_x)):
        if d_x[i] in d_y:
            return d_x[i]
    
for _ in range(T):
    N = int(input())

    p = [0] * (N+1)    
       
    for i in range(N-1):
        a,b = map(int,input().split())
        p[b] = a
        
    X,Y = map(int,input().split())

    result.append(lca(X,Y))
    
print(*result,sep="\n")
