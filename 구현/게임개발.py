n,m = map(int,input().split())
x,y,dir = map(int,input().split())
d = [[0] * m for _ in range(n)]
d[x][y]=1
array=[]
for i in range(n):
    array.append(list(map(int,input().split())))

la_col = [-1,0,1,0]
la_row = [0,1,0,-1]

def lft():
    global dir
    dir-=1
    if dir==-1:
        dir=3
cnt=1
turn_cnt=0

while True:
    lft()
    temp_x = x+la_col[dir]
    temp_y = y+la_row[dir]

    if d[temp_x][temp_y] == 0 and array[temp_x][temp_y]==0:
        d[temp_x][temp_y]=1
        cnt+=1
        x=temp_x
        y=temp_y
        turn_cnt=0
        continue
    else:
        turn_cnt+=1
    #네방향 모두 막혔을때
    if turn_cnt == 4:
        # 뒤돌기
        temp_x = x-la_col[dir]
        temp_y = y-la_row[dir]
        # 뒤로 갈수 있으면
        if array[temp_x][temp_y]==0:  
            x=temp_x
            y=temp_y
            turn_cnt=0
        else:
            break
print(cnt)