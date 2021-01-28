n = int(input())

array = list(map(int, input().split()))
# DP 초기화
d = [0] * 100
d[0]=array[0]
d[1]=max(array[0],array[1])

for i in range(2, n):
    # DP 테이블에 저장된 최댓값을 측정
    d[i] = max(d[i-1],d[i-2]+array[i])

print(d[n-1])