import sys,math,heapq
input = sys.stdin.readline

N = int(input())

array = [(0,0)]
p = [i for i in range(N+1)]

for _ in range(N):
    a,b = map(float,input().split())
    array.append((a,b))

q = []

for i in range(1,N+1):
    x,y = array[i][0],array[i][1]
    
    for j in range(i+1,N+1):
        x2,y2 = array[j][0],array[j][1]
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

result = 0

while q:
    d,x,y = heapq.heappop(q)
    
    if find(x) != find(y):
        union(x,y)
        result+=d
        
print("{:.2f}".format(result))