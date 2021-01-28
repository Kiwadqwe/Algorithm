n = int(input())
# set 함수를 사용하여 집합(set) 자료형에 기록
array = set(map(int, input().split()))
# print(array)
m = int(input())
x = list(map(int,input().split()))

for i in x:
    if i in array:
        print('yes',end = ' ')
    else:
        print('no', end = ' ')