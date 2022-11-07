import sys,time
start = time.time()
input = sys.stdin.readline

N = int(input())
array = [[] for _ in range(N+1)]
p = [0] * (N+1)
d = [0] * (N+1)
c = [0] * (N+1)

def dfs(x,depth):
    c[x] = True
    d[x] = depth
    
    for y in array[x]:
        if c[y]: continue
        p[y] = x
        dfs(y,depth+1)

for _ in range(N-1):
    a,b = map(int,input().split())
    
    array[a].append(b)
    array[b].append(a)

dfs(1,0)

def lca(a,b):
    while d[a] != d[b]:
        # 깊이 맞추기
        # 깊이가 동일하게 만들어야돼서
        # 만약 깊이가 더 높을 경우 부모로 이동한다.
        if d[b] < d[a]:
            a = p[a]
        else:
            b = p[b]
            
    # 깊이가 같아지므로 해당 공통 부모를 출력
    while a != b:
        a = p[a]
        b = p[b]
        
    return a

M = int(input())

result = []

for _ in range(M):
    a,b = map(int,input().split())
    result.append(lca(a,b))

print(*result, sep="\n")

end = time.time()

print(end-start)