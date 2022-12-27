import sys,math

input = sys.stdin.readline

N = int(input())
result = []

def dfs(n):
    for i in range(2,int(math.sqrt(int(n)))+1):
        if not int(n) % i:
            return
    
    if len(n) == N:
        result.append(n)
        return

    for i in ['1','3','7','9']:
        dfs(n+i)

for i in ['2','3','5','7']:
    dfs(i)
        
print(*result, sep="\n")