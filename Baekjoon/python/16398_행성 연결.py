import sys
input = sys.stdin.readline

n = int(input())

array = []
parent = [0] * (n+1)

# 특정 원소가 속한 집합 찾기
def find_parent(parent,x):
    if parent[x] != x:
        parent[x] = find_parent(parent,parent[x])
    return parent[x]

# 합치기
def union_parent(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

# 입력
for _ in range(n):
    array.append(list(map(int,input().split())))

# 본인 초기화
for i in range(1,n+1):
    parent[i] = i
    
edges = []
result = 0

# 간선의 비용 입력
for i in range(n):
    for j in range(n):
        c = array[i][j]
        edges.append((c,i,j))

# 비용순으로 정렬
edges.sort()

for edge in edges:
    c,a,b = edge
    # 싸이클이 발생하지 않을 경우
    if find_parent(parent,a) != find_parent(parent,b):
        union_parent(parent,a,b)
        # 비용 추가
        result+=c
print(result)

# 3
# 0 2 3
# 2 0 1
# 3 1 0

# 3

# 5
# 0 6 8 1 3
# 6 0 5 7 3
# 8 5 0 9 4
# 1 7 9 0 6
# 3 3 4 6 0

# 11