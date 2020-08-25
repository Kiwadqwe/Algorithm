N = int(input())
cnt = 0
list = [500, 100, 50, 10]

for coin in list:
    cnt = N // coin
    N = N % coin
    print(coin,'는', cnt)
