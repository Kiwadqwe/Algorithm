n,m = map(int,input().split())
array= []

for i in range(n):
    array.append(int(input()))
# 10001을 담는 m+1개의 DP테이블 생성
d = [10001]*(m+1)
d[0]=0

for i in range(n):
    for j in range(array[i],m+1):
        d[j]=min(d[j],d[j-array[i]]+1)
              
if d[m]==10001:
    print(-1)
else:
    print(d[m])