import sys
from collections import deque
input = sys.stdin.readline

T = int(input())

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited = [[False] * (M+2) for _ in range(N+2)]
    visited[x][y] = True
    dx,dy = [-1,0,1,0],[0,1,0,-1]
    cnt = 0
    ndoor = [deque() for _ in range(26)]
    
    while q:
        x,y = q.popleft()
        
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<N+2 and 0<=ny<M+2:
                if not visited[nx][ny] and array[nx][ny] != '*':
                    visited[nx][ny] = True
                    if array[nx][ny].islower():
                        a = ord(array[nx][ny])-ord('a')
                        key[a] = True
                        # 먹은 키로 열 수 있는 문
                        while ndoor[a]:
                            x,y = ndoor[a].popleft()
                            q.append((x,y))
                            
                    elif array[nx][ny].isupper():
                        a = ord(array[nx][ny])-ord('A')
                        # 키가 없을때
                        if not key[a]:
                            ndoor[a].append((nx,ny))
                            continue
                    elif array[nx][ny] == '$':
                        cnt+=1

                    q.append((nx,ny))
                    
    return cnt

result = []
for t in range(T):
    N,M = map(int,input().split())
    array = [['.'] * (M+2) for _ in range(N+2)]
    key = [False] * 26
    
    for i in range(N):
        ipu = list(str(input().rstrip()))
        for j in range(M):
            array[i+1][j+1] = ipu[j]

    alpha = list(str(input().rstrip()))
    
    if '0' not in alpha:
        for k in alpha:
            key[ord(k)-ord('a')] = True
    
    result.append(bfs(0,0))

print(*result,sep="\n")