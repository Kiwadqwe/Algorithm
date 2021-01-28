n = int(input())

d = [0]*1001
d[1]=1
d[2]=3

for i in range(3,n+1):
    # 바닥을 채우는 방법 경우의 수 %796796
    d[i]= (d[i-1]+2*d[i-2]) % 796796
print(d[n])