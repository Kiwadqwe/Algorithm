import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
num = int(input())
array = list(map(int,input().split()))
d = defaultdict(int)
result = []

for i in range(num):
    d[array[i]] += 1
    # 같은 학생의 번호가 있는 경우
    if array[i] not in result:
        if len(result) == n:
            INF = int(1e9)
            for j in range(len(result)):
                if d[result[j]] < INF:
                    # 추천 받은 횟수가 가장 적은 학생
                    INF = d[result[j]]
                    # 추천 받은 횟수가 가장 적은 학생의 번호
                    idx = result[j]
            # 추천 받은 횟수가 가장 작은 학생 삭제
            result.remove(idx)
            # 딕셔너리에도 삭제
            del(d[idx])
            result.append(array[i])
        else:    
            result.append(array[i])
result.sort()
print(*result)

# 3
# 9
# 2 1 4 3 5 6 2 7 2

# 2 6 7