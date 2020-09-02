def find_parent(parent,x):
    if parent[x] !=x:
        parent[x] = find_parent(parent,parent[x])
    return parent[x]

def union_parent(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)
    if a<b:
        parent[b]= a
    else:
        parent[a]= b
n,m = map(int,input().split())
#집의 개수 n+1으로 부모 테이블 초기화 
parent = [0] *(n+1)
# 모든 간선을 담을 리스트와 최종 비용을 담을 변수
edges=[]
result=0

for i in range(1,n+1):
    parent[i] = i

for _ in range(m):
    a,b,c = map(int,input().split())
    # 비용순으로 정렬하기 위해 튜플 첫번째를 비용으로 설정
    edges.append((c,a,b))

edges.sort()
last=0
for edge in edges:
    c,a,b=edge
    #싸이클 확인
    if find_parent(parent,a)!=find_parent(parent,b):
        union_parent(parent,a,b)
        result+=c
        last = c
print(result,last,result-last)

