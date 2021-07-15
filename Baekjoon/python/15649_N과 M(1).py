import sys
from itertools import permutations  
input = sys.stdin.readline

n, m = map(int,input().split())
array = []
visited = [True]+[False]*n

def dfs(n,m,start):
    if m == start:
        print(' '.join(map(str,array)))
        return
    
    for i in range(1,n+1):
        if not visited[i]:
            visited[i] = True
            array.append(i)
            dfs(n,m,start+1)
            # pop을 해서 리스트 초기화
            array.pop()
            # 모든 수열을 출력하기 위해서 방문했던 방을 False처리 
            visited[i] =False
dfs(n,m,0)

# for i in permutations(range(1,n+1),m):
#     print(' '.join(map(str,i)))

# 4 4

# 1 2 3 4
# 1 2 4 3
# 1 3 2 4
# 1 3 4 2
# 1 4 2 3
# 1 4 3 2
# 2 1 3 4
# 2 1 4 3
# 2 3 1 4
# 2 3 4 1
# 2 4 1 3
# 2 4 3 1
# 3 1 2 4
# 3 1 4 2
# 3 2 1 4
# 3 2 4 1
# 3 4 1 2
# 3 4 2 1
# 4 1 2 3
# 4 1 3 2
# 4 2 1 3
# 4 2 3 1
# 4 3 1 2
# 4 3 2 1