import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int,input().split()))
b = []
tp = sorted(a)

for i in range(n):
    b.append(tp.index(a[i]))
    # 같은 숫자가 있을 경우 인덱스 앞쪽에 있는 인덱스 추출됨
    tp[b[i]] = -1
    
print(*b)

# 3
# 2 3 1

# 1 2 0