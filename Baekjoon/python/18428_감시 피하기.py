import sys,copy
from itertools import combinations

input = sys.stdin.readline

n = int(input())
array = [list(map(str,input().split())) for _ in range(n)]
tr,sd = [],[]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def move():
    for x,y in tr:
        temp = copy.deepcopy(array)
        for i in range(4):
            a,b = x,y
            while True:
                nx,ny = a+dx[i],b+dy[i]
                if 0<=nx<n and 0<=ny<n:
                    if temp[nx][ny] == 'X':
                        temp[nx][ny] = 'T'
                    elif temp[nx][ny] == 'S':
                        return False
                    elif temp[nx][ny] == 'O':
                        break
                    a,b =nx,ny
                else:
                    break
    return True

for i in range(n):
    for j in range(n):
        if array[i][j] == 'X':
            sd.append((i,j))
        elif array[i][j] == 'T':
            tr.append((i,j))

result = False
for cm in combinations(sd,3):
    for x,y in cm:
        array[x][y] = 'O'
    if move():
        result = True
        break
    if result:
        break
    for x, y in cm:
        array[x][y] = 'X'

if result:
    print("YES")
else:
    print("NO")

# 4
# S S S T
# X X X X
# X X X X
# T T T X

# NO