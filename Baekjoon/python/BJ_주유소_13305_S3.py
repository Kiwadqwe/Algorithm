import sys
input = sys.stdin.readline

N = int(input())
move = list(map(int,input().split()))
city = list(map(int,input().split()))
money = 0
m = city[0]

for i in range(N-1):
    # 기름값이 제일 저렴한 도시
    if city[i] < m:
        m = city[i]
        
    money += m * move[i]
    
print(money)