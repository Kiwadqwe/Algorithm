import sys,heapq,math
input = sys.stdin.readline

N,M = map(int,input().split())

array = [(0,0)]
p = [i for i in range(N+1)]

for _ in range(N):
    a,b = map(int,input().split())
    array.append((a,b))

q = []

for i in range(1,N):
    x = array[i][0]
    y = array[i][1]
    for j in range(i+1,N+1):
        x2 = array[j][0]
        y2 = array[j][1]
        d = math.sqrt(math.pow(abs(x-x2),2)+math.pow(abs(y-y2),2))
        heapq.heappush(q,(d,i,j))  

def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    
    return p[x]

def union(x,y):
    x = find(x)
    y = find(y)
    
    if x < y:
        p[y] = x
    else:
        p[x] = y

for _ in range(M):
    a,b = map(int,input().split())
    if find(a) != find(b):
        union(a,b)
        N-=1
    
result = 0
while q and N-1 != 0:
    d,x,y = heapq.heappop(q)
    
    if find(x) != find(y):
        result+=d
        union(x,y)
        N-=1 

print("{:.2f}".format(result))