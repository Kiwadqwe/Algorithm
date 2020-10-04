import sys

input = sys.stdin.readline

n = int(input())

d=[0]*10000

def fibo(x):
    d[0]=1
    d[1]=1
    for i in range(2,x+1):
        # 이미 dp테이블에 저장된 값
        if d[i]==0:
            d[i]=(d[i-1]+d[i-2]*2)%10007
    return d[x] 

print(fibo(n))