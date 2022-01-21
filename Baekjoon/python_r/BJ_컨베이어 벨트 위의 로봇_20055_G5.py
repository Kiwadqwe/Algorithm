import sys
from collections import deque

input = sys.stdin.readline

N,K = map(int,input().split())
belt = deque(list(map(int,input().split())))
robot = deque([False] * N)
cnt = 1

while True:
    # 회전
    belt.rotate()
    robot.rotate() 
    robot[N-1] = False

    # 로봇 이동
    if True in robot:
        for i in range(N-2,-1,-1):
            # 해당칸에 로봇이 있을때 이동할 다음칸이 로봇이 없거나 내구도가 1이상
            if robot[i] and not robot[i+1] and 1 <= belt[i+1]:
                robot[i] = False
                robot[i+1] = True
                belt[i+1] -= 1

    robot[N-1] = False
    # 로봇 올리기    
    if 0 < belt[0] and not robot[0]:
        robot[0] = True
        belt[0]-=1

    # 0이 K개 이상인지 체크
    if K <= belt.count(0):
        break

    cnt+=1

print(cnt)
