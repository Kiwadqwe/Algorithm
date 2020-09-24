import sys

def find_parent(parent,x):
    if parent[x]!=x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)
    if a<b:
        parent[b]=a
    else:
        parent[a]=b

input=sys.stdin.readline
n,m = map(int,input().split())
parent = [0]*(n+1)
edges=[]

for i in range(1,n+1):
    parent[i]=i

for i in range(m):
    a,b,z = map(int,input().split())
    edges.append((z,a,b))

# 정렬을 해서 최소금액만 지나가면 됨, 싸이클이 발생하는 경우는 제외 시킨다.
edges.sort()
result=0
hap=0
for edge in edges:
    z,a,b=edge
    if find_parent(parent,a) != find_parent(parent,b):
        union_parent(parent,a,b)
        result+=z
    hap+=z
print(hap-result)