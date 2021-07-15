import sys
input = sys.stdin.readline

n, k = map(int,input().split())
coin = []
array = [1]+[0]*(k)

for _ in range(n):
    coin.append(int(input()))

# coin에 담긴 수로
# 1~10까지 각각의 숫자를 만들수 있는 경우를 
# array에 저장
for cn in coin:
    for i in range(cn,k+1):
        cnt =i-cn
        array[i] += array[cnt]
print(array[k])

# 3 10
# 1
# 2
# 5

# 10