import sys
sys.setrecursionlimit(111111)
input = sys.stdin.readline

t = int(input())
graph = []

def dfs(start):
    global result
    visited[start]=True
    team.append(start)
    check = graph[start]
    if not visited[check]:
        dfs(check)
    else:
        if check in team:
            result += team[team.index(check):]
        return
save = []
for i in range(t):
    n = int(input())
    graph = [0] + list(map(int, input().split()))
    visited = [False] * (n+1)
    result = []
    
    for i in range(1,n+1):
        if not visited[i]:
            team = []
            dfs(i)
    save.append(n-len(result))

for i in save:
    print(i)


# 2
# 7
# 3 1 3 7 3 4 6
# 8
# 1 2 3 4 5 6 7 8

# 3
# 0