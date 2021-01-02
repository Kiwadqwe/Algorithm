import sys
input = sys.stdin.readline

t = int(input())
save = []
def fibo(x):
    if a==0:
        save.append((1,0))
    elif a==1:
        save.append((0,1))
    elif a==2:
        save.append((1,1))
    else:
        for i in range(2,x+1):
            array.append(array[i-1]+array[i-2])
        save.append((array[x-1],array[x]))

for _ in range(t):
    a = int(input())
    array =[0,1]
    fibo(a)

for sa in save:
    print(*sa)
# 3
# 0
# 1
# 3
    
# 1 0
# 0 1
# 1 2