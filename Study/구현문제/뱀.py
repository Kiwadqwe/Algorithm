n= int(input())
k= int(input())
d=[[0]*(n+1) for _ in range(n+1)]

#동남서북 좌표
d_row=[0,1,0,-1]
d_col=[1,0,-1,0]
array=[]
tail=[[0]*(n+1) for _ in range(n+1)]
#사과 위치 
for i in range(k):
    a,b = map(int,input().split())
    d[a][b]=1

l= int(input())
for i in range(l):
    p,c =input().split()
    array.append((int(p),c))

def turn(dir,c):
    if c=="D":
        dir=(dir+1)%4
    else:
        dir=(dir-1)%4
    return dir
def start():
    time=0
    dir=0
    x,y=1,1
    leng=1
    turn_cnt=0
    while True:
        temp_x = x+d_row[dir]
        temp_y = y+d_col[dir]
        if temp_x <1 or temp_y <1 or temp_x>n or temp_y>n:
            time+=1
            break
        else:
            x,y=temp_x,temp_y
            time+=1
        # if leng>=2 and tail[x][y]==1:
        #     break
        if d[x][y]==1:
            leng+=1
            d[x][y]=0
            tail[x][y]=1
        if turn_cnt<l and time==array[turn_cnt][0]:
            dir=turn(dir,array[turn_cnt][1])
            turn_cnt+=1
    return time
print(start())


