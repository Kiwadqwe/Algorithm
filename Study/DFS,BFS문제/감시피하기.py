from itertools import combinations

n=int(input())
graph=[]
array=[]
teacher=[]

for i in range(n):
    graph.append(list(input().split()))
    for j in range(n):
        if graph[i][j]=="X":
            array.append((i,j))
        if graph[i][j]=="T":
            teacher.append((i,j))

#0 왼쪽 1 오른쪽 2 위 3 아래
def watch(x,y,direction):
    if direction==0:
        while y>=0:
            if graph[x][y]=="S":
                return True
            if graph[x][y]=="O":
                return False
            y-=1
    if direction==1:
        while y<n:
            if graph[x][y]=="S":
                return True
            if graph[x][y]=="O":
                return False
            y+=1
    if direction==2:
        while x>=0:
            if graph[x][y]=="S":
                return True
            if graph[x][y]=="O":
                return False
            x-=1
    if direction==3:
        while x<n:
            if graph[x][y]=="S":
                return True
            if graph[x][y]=="O":
                return False
            x+=1
    # 모든 사항에 해당 하지 않으므로
    return False

# 장애물 설치 이후에, 한 명이라도 학생이 감지되는지 검사
def process():
    # 모든 선생님의 위치를 하나씩 확인
    for x,y in teacher:
        for i in range(4):
            if watch(x,y,i):
                return True
    return False
# 학생이 한명이라도 감지되지 않도록 설치할 수 있는지의 여부
find = False

# 빈 공간에서 3개를 뽑는 모두 조합을 확인
for i in combinations(array,3):
    # 장애물 설치해보기
    for x,y in i:
        graph[x][y]="O"
    # 학생이 한명도 감지되지 않은 경우
    if not process():
        # 원하는 경우를 발견한 것임
        find = True
        break
    # 설치된 장애물을 다시 없애기
    for x,y in array:
        graph[x][y]= 'X'
if find:
    print('YES')
else:
    print('NO')