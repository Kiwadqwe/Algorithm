import sys
from collections import deque
input = sys.stdin.readline

n,k = map(int,input().split())
array = deque(list(map(int,input().split())))
robot = deque(list([0]*n))
result=1

while True:
    # 1. 벨트 한 칸 회전
    array.rotate(1)
    robot.rotate(1)
    robot[-1] =0
    
    # 2. 로봇 이동
    # 로봇이 있다면
    if sum(robot):
        for i in range(n-2,-1,-1):
            if robot[i] and array[i+1] and not robot[i+1]:
                robot[i] = 0
                robot[i+1] = 1
                array[i+1] -= 1

    robot[-1] = 0
    # 3. 0번에 로봇이 없는경우 하나 올림
    if not robot[0] and array[0]:
        robot[0] = 1
        array[0] -= 1

    # 4. 탈출조건
    if array.count(0) >= k:
        break
    result+=1

print(result)

# 3 6
# 10 10 10 10 10 10

# 31