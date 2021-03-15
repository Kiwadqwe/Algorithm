import sys
from itertools import combinations
input = sys.stdin.readline

n = int(input())
array = [list(map(int,input().split())) for _ in range(n)]
temp = combinations(range(n),n//2)
team = []
result = sys.maxsize

for t in temp:
    team.append(t)

for i in range(len(team)//2):
    te,te2 = team[i],team[-i-1]
    start,link = 0,0
    for i in range(n//2-1):
        for j in range(i+1,n//2):
            start += array[te[i]][te[j]] + array[te[j]][te[i]]
            link += array[te2[i]][te2[j]] + array[te2[j]][te2[i]]
    result = min(result,abs(start-link))

print(result)    

# 6
# 0 1 2 3 4 5
# 1 0 2 3 4 5
# 1 2 0 3 4 5
# 1 2 3 0 4 5
# 1 2 3 4 0 5
# 1 2 3 4 5 0

# 2