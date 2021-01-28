num = int(input())
ipu = input().split()

x,y=1,1
dx = [0,0,-1,1]
dy = [-1,1,0,0]
move = ['L','R','U','D']

for i in ipu:
    for j in range(len(move)):
        if i==move[j]:
            temp_x = x+dx[j]
            temp_y = y+dy[j]
    if temp_x<1 or temp_y <1 or temp_x > num or temp_y >num:
        continue
    x,y = temp_x, temp_y
print(x,y)