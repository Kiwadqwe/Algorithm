import sys

input = sys.stdin.readline

N,M = map(int,input().split())

array = [int(input()) for _ in range(N)]

s,e = min(array),max(array) * M
result = e

while s <= e:
    m = (s+e)//2
    
    p = 0
    
    for i in range(N):
        # 시간대에 가능한 사람 수
        p += m//array[i]
    
    if M <= p:
        e = m-1
        result = min(result,m)
    else:
        s = m+1
        
print(result)