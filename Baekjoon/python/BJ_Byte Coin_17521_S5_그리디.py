import sys
input = sys.stdin.readline

N,W = map(int,input().split())
array = [int(input()) for _ in range(N)]

for i in range(len(array)):
    # 첫날에 샀다가 만약에 다음날이 싸면 바로 팔자
    if i == 0:
        coin = W//array[0]
        total = W%array[0]
        buy = True

    if i == N-1:
        total += coin*array[N-1]
        break

    if array[i] <= array[i+1]:
        # 살 경우
        if not buy:
            coin = total//array[i]
            total -= array[i]*coin 
            buy = True
    elif array[i] >= array[i+1]:
        # 팔 경우
        if buy:
            total += coin*array[i]
            coin = 0
            buy = False

print(total)