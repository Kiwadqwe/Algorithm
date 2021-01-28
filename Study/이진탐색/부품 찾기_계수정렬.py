n = int(input())
array = [0] * 1000000
# 전체 부품 입력 받아서 1 넣어줌
for i in input().split():
    array[int(i)] = 1

m = int(input())
x = list(map(int,input().split()))

# x의 리스트를 하나씩 array 리스트에서 찾음
for i in x:
    if array[i]==1:
        print('yes', end=' ')
    else:
        print('no', end= ' ')