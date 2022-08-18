import sys
input = sys.stdin.readline

N = int(input())
array = [list(map(int,input().split())) for _ in range(N)]

a,b,d = 0,0,0

def go(x,y,l):
    global a,b,d
    
    for i in range(x,x+l):
        for j in range(y,y+l):
            if array[x][y] != array[i][j]:
                for r in range(3):
                    for c in range(3):
                        go(x+l//3 *r,y+l//3*c,l//3)
                return
    
    if array[x][y] == -1:
        a+=1
    elif array[x][y] == 0:
        b+=1
    elif array[x][y] == 1:
        d+=1 
    

go(0,0,N)
print(a)
print(b)
print(d)