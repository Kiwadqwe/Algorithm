import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
array = [list(input().strip()) for _ in range(N)]
visited = [[[False] * 2 for j in range(M)] for i in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def bfs():
    q = deque()
    q.append((0, 0, 1, 1))
    visited[0][0][1] = True

    while q:
        x, y, cnt, check = q.popleft()

        if x == N-1 and y == M-1:
            return cnt

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny][check]:
                    if array[nx][ny] == "1" and check:
                        visited[nx][ny][check] = True
                        q.append((nx, ny, cnt+1, False))
                    # 벽부술 기회가 남든지 없든지 0일때는 무조건 갈 수 있음
                    elif array[nx][ny] == "0":
                        visited[nx][ny][check] = True
                        q.append((nx, ny, cnt+1, check))

    return -1


print(bfs())
