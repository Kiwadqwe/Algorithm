import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
graph = ''

for _ in range(3):
    # graph를 리스트 형식이 아닌 문자열로 구성
    graph += ''.join(map(str,input().split()))
    
# count값 올리기 위하여 딕셔너리로 생성
dist = dict()

def bfs():
    q = deque()
    q.append(graph)
    # 0번 키값 저장
    dist[graph]=0
    while q:
        v = q.popleft()
        # v가 123456780이 됬을때 탈출조건
        if v == '123456780':
            return dist[v]
        # v에서 0값 추출
        t = v.find('0')
        # x,y값
        x,y = t//3,t%3
        
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<3 and 0<=ny<3:
                # 변경할 인덱스값
                change=nx*3+ny
                d=list(v)
                # d 리스트에 값 변경
                d[change],d[t]=d[t],d[change]
                # d가 리스트 형식으로 되있기 때문에 변수로 값 저장
                move = str(''.join(d))
                # 딕셔너리 dist move 값이 없다면
                if not dist.get(move):
                    # move 값을 dist에 저장하고 인덱스 증가
                    dist[move] = dist[v]+1
                    q.append(move)
    return -1
print(bfs())

# 1 0 3
# 4 2 5
# 7 8 6

# 3

# 3 6 0
# 8 1 2
# 7 4 5

# -1