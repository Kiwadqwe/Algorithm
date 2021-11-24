import sys
from collections import deque
input = sys.stdin.readline

K = int(input())
H, W = map(int, input().split())
visited = [[[False] * (K+1) for j in range(H)] for i in range(W)]
array = [list(map(int, input().split())) for _ in range(W)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
night_dx = [-1, 1, 2, 2, 1, -1, -2, -2]
night_dy = [-2, -2, -1, 1, 2, 2, 1, -1]


def bfs():
    q = deque()
    q.append((0, 0, 0, K))
    visited[0][0][K] = True

    while q:
        x, y, cnt, k = q.popleft()

        if x == W-1 and y == H-1:
            return cnt

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if 0 <= nx < W and 0 <= ny < H:
                if not visited[nx][ny][k] and array[nx][ny] != 1:
                    visited[nx][ny][k] = True
                    q.append((nx, ny, cnt+1, k))

        if 0 < k:

            for d in range(8):
                nx = x+night_dx[d]
                ny = y+night_dy[d]

                if 0 <= nx < W and 0 <= ny < H:
                    if not visited[nx][ny][k-1] and array[nx][ny] != 1:
                        visited[nx][ny][k-1] = True
                        q.append((nx, ny, cnt+1, k-1))

    return -1


cnt = bfs()
print(cnt)
