import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(map(str,input().rstrip())) for _ in range(N)]

p = [i for i in range(N*M)]
d = {'D': [1,0], 'L': [0,-1], 'U': [-1,0], 'R': [0,1]}

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
    
def next_position(x,y):
    dir = array[x][y]
    dx,dy = d[dir]
    nx,ny = dx+x,dy+y
    
    if 0<=nx<N and 0<=ny<M:
        return nx*M+ny

    return -1

for x in range(N):
    for y in range(M):
        next_k = next_position(x,y)
        now_k = x*M+y
        
        if next_k != -1 and find(now_k) != find(next_k):
            union(now_k,next_k)

for i in range(len(p)):
    find(i)

print(len(set(p)))