from collections import deque

n,k = map(int,input().split())
# 모든 노드
graph=[]
# 바이러스 노드
array=[]
# 동서남북 좌표 이동
dx=[-1,0,1,0]
dy=[0,1,0,-1]

for i in range(n):
    # 모든 값들을 넣어줌
    graph.append(list(map(int,input().split())))
    for j in range(k):
        # 바이러스이면
        if graph[i][j]!=0:
            #바이러스 좌표값을 바이러스 리스트에 넣어줌
            array.append((graph[i][j],0,i,j))

s,x,y = map(int,input().split())

array.sort()
# q에 바이러스 리스트 삽입
q= deque(array)

while q:
    # array 리스트 순서대로 바이러스와 시간, 좌표값 지정
    virus,virus_s,virus_x,virus_y=q.popleft()
    # 입력 s초가 되면 종료
    if virus_s==s:
        break
    # 네 방향을 살피기 위하여 4번 돔
    for i in range(4):
        # 좌표를 이동    
        nx = virus_x+dx[i]
        ny = virus_y+dy[i]
        # 좌표상에서 벗어나지 않으면
        if nx>=0 and ny>=0 and nx<n and ny<n:
            # 좌표값이 바이러스가 아니라면
            if graph[nx][ny]==0:
                # 바이러스 지정
                graph[nx][ny]=virus
                # q에 다시 셋팅
                q.append((virus,virus_s+1,nx,ny))

print(graph[x-1][y-1])