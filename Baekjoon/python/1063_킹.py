import sys
input = sys.stdin.readline

king, stone, N = map(str, input().split())
array = [input().strip() for _ in range(int(N))]

dx = [1, 1, 0, -1, -1, -1, 0, 1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]


def go(m):
    if m == 'R':
        move = 2
    elif m == 'L':
        move = 6
    elif m == 'B':
        move = 4
    elif m == 'T':
        move = 0
    elif m == 'RT':
        move = 1
    elif m == 'LT':
        move = 6
    elif m == 'RB':
        move = 3
    elif m == 'LB':
        move = 5

    return move


x = ord(king[0])-64
y = int(king[1])
s_x = ord(stone[0])-64
s_y = int(stone[1])

for arr in array:
    d = go(arr)
    nx = x+dy[d]
    ny = y+dx[d]

    sx = s_x+dy[d]
    sy = s_y+dx[d]

    if 1 <= nx <= 8 and 1 <= ny <= 8:
        if nx == s_x and ny == s_y:
            if 1 <= sx <= 8 and 1 <= sy <= 8:
                x, y = nx, ny
                s_x, s_y = sx, sy
        else:
            x, y = nx, ny


print(f'{chr(x+64)}{y}')
print(f'{chr(s_x+64)}{s_y}')
