import sys
input = sys.stdin.readline
n = int(input())
array = [-1]+list(map(int,input().split()))
s = int(input())
student = [list(map(int,input().split())) for _ in range(s)]
check = {1:0, 0:1}

for i in range(s):
    if student[i][0] == 1:
        # 남학생
        for k in range(student[i][1],n+1):
            if k % student[i][1] == 0:
                array[k] = check[array[k]]
        # 여학생
    elif student[i][0] == 2:
        nx,ny = student[i][1],student[i][1] 
        array[student[i][1]] = check[array[student[i][1]]]

        while True:
            nx -= 1
            ny += 1
            if 0 < nx and ny <=n:
                if array[nx] == array[ny]:
                        array[nx] = check[array[nx]]
                        array[ny] = check[array[ny]]
                else:
                    break               
            else:
                break

for i in range(1,n,20):
    print(*array[i:i+20])

# 8
# 0 1 0 1 0 0 0 1
# 2
# 1 3
# 2 3

# 1 0 0 0 1 1 0 1