# 같은 팀 여부 찾기
def find_parent(parent,x):
    if parent[x] != x:
        parent[x] = find_parent(parent,parent[x])
    return parent[x]
# 팀 합치기
def union_parent(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n,m = map(int,input().split())
# 부모 테이블 초기화
parent = [0]* (n+1)
# 자기 자신으로 초기화
cnt=[]
for i in range(0,n+1):
    parent[i] =i
# 같은 팀 여부, 팀 합치기 연산 확인
for i in range(m):
    check,a,b = map(int,input().split())
    # 팀 합치기 일 때
    if check==0:
        union_parent(parent,a,b)
    elif check==1:
        # 같은 팀 여부 확인= 싸이클이 발생했을 때, 찾기 연산일 때
        if find_parent(parent,a) == find_parent(parent,b):
            print("YES")           
        else:
            print("NO")


