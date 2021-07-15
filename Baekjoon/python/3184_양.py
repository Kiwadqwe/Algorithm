import sys
from collections import deque
input = sys.stdin.readline

r,c = map(int,input().split())
visited = [[False] * c for _ in range(r)]
array = [list(map(str,input().strip())) for _ in range(r)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    cnt,cnt1 = 0,0
    if array[x][y] =='v':
        cnt+=1
    elif array[x][y] =='o':
        cnt1+=1
        
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx,ny = dx[i]+x,dy[i]+y
            if 0<=nx<r and 0<=ny<c:
                if not visited[nx][ny] and array[nx][ny] != '#':
                    if array[nx][ny] == 'v':
                        cnt+=1
                    elif array[nx][ny] == 'o':
                        cnt1+=1
                    visited[nx][ny] = True
                    q.append((nx,ny))
    return cnt,cnt1

result,result1=0,0

for i in range(r):
    for j in range(c):
        if array[i][j] != '#' and not visited[i][j]:
            wolf,sheep = bfs(i,j)
            if wolf >= sheep:   
                result1+=wolf
            else:
                result+=sheep
print(result,result1)

# 9 12
# .###.#####..
# #.oo#...#v#.
# #..o#.#.#.#.
# #..##o#...#.
# #.#v#o###.#.
# #..#v#....#.
# #...v#v####.
# .####.#vv.o#
# .......####.

# 3 5