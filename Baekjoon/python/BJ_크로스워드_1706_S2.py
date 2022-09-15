import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(input().strip()) for _ in range(N)]
result = []
d = [[0,1],[1,0]]

def go(x,y,k):
    global answer
   
    nx,ny = x+d[k][0],y+d[k][1]
    
    if 0<=nx<N and 0<=ny<M:
        if array[nx][ny] != '#':
            visited[nx][ny] = True
            answer += array[nx][ny]
            go(nx,ny,k)
        else:
            return answer            
    else:
        return answer

for k in range(2):
    visited = [[False] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if not visited[i][j] and array[i][j] != '#':
                answer = array[i][j]
                go(i,j,k)
                if 1 < len(answer): result.append(answer)
                
result.sort()

print(result[0])