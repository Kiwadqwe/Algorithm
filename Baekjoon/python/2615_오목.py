import sys
input = sys.stdin.readline

array,white,black = [],[],[]

# 우 우하 하 우상
dx = [0,1,1,-1]
dy = [1,1,0,1]

for i in range(19):
    array.append(list(map(int,input().split())))
    for j in range(19):
        if array[i][j] == 1:
            black.append((i,j))
        elif array[i][j] == 2:
            white.append((i,j))

white_check,black_check = False,False
r,c,result =0,0,0

def omok(x,y):
    global result,r,c

    for k in range(4):
        x,y = a,b
        cnt = 1
        while True:
            nx = dx[k]+x
            ny = dy[k]+y
            if 0<=nx<19 and 0<=ny<19:
                if array[nx][ny] == array[x][y]:
                    cnt+=1
                    x,y = nx,ny
                else:
                    break

                if cnt > 5:
                    break
            else:
                break

        if cnt == 5:
            if array[a][b] == array[a-dx[k]][b-dy[k]]:
                return False
            result = array[a][b]
            r,c = a,b
            return True

    return False
        
for a,b in white:
    white_check = omok(a,b)
    if white_check:
        break

for a,b in black:
    black_check = omok(a,b)
    if black_check:
        break
    
if white_check or black_check:
    print(result)
    print(r+1,c+1)
else:
    print(0)

# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0
# 0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0
# 0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

# 1
# 3 2