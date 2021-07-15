import sys

input = sys.stdin.readline

n, m = map(int, input().split())
r, c, d = map(int, input().split())

graph = []

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(n):
    graph.append(list(map(int, input().split())))

cnt=1

def turn(r,c,d):
    global cnt
    graph[r][c]=2
    
    for i in range(4):
        # 방향이동
        move = (d+3) % 4
        dr, dc = r+dx[move], c+dy[move]
        # 청소안한곳이 있다면
        if 0 <= dr < n and 0 <= dc < m and graph[dr][dc] == 0:
            cnt += 1
            turn(dr,dc,move)
            return
        d = move
    # 한칸 후진
    back = (move+2)%4
    dr,dc = r+dx[back],c+dy[back]
    if graph[dr][dc]==1:
        return
    else:
        turn(dr,dc,d)

turn(r,c,d)
print(cnt)


# 11 10
# 7 4 0
# 1 1 1 1 1 1 1 1 1 1
# 1 0 0 0 0 0 0 0 0 1
# 1 0 0 0 1 1 1 1 0 1
# 1 0 0 1 1 0 0 0 0 1
# 1 0 1 1 0 0 0 0 0 1
# 1 0 0 0 0 0 0 0 0 1
# 1 0 0 0 0 0 0 1 0 1
# 1 0 0 0 0 0 1 1 0 1
# 1 0 0 0 0 0 1 1 0 1
# 1 0 0 0 0 0 0 0 0 1
# 1 1 1 1 1 1 1 1 1 1
