from collections import deque

n,m = map(int, input().split())

array = []
vi_col = [-1,0,1,0]
vi_row = [0,1,0,-1]

for i in range(n):
    array.append(list(map(int, input())))
def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    while queue:
        x,y = queue.popleft()
        
        for i in range(4):
            temp_x = x+vi_col[i]
            temp_y = y+vi_row[i]
            if temp_x>=n or temp_y>=m or temp_x<0 or temp_y<0:
                continue
            if array[temp_x][temp_y]==1:
                array[temp_x][temp_y]= array[x][y]+1 # 출력할때
                queue.append((temp_x,temp_y))
            else:
                continue
    # 가장 오른쪽 아래까지의 최단 거리 반환
    return array[n-1][m-1] 
print(bfs(0,0))