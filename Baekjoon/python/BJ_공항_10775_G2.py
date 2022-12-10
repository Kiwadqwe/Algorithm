import sys
input = sys.stdin.readline

G = int(input())
P = int(input())
p = [i for i in range(G+1)]
result = 0

def find(x):
    if x != p[x]:
        p[x] = find(p[x])

    return p[x]

for _ in range(P):
    a = int(input())
    f = find(a)
    
    if not f: break
    
    p[f] = p[f-1]

    result+=1
    
print(result)