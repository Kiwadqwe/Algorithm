ipu = int(input())
# DP테이블 생성
d = [0] *30001

for i in range(2,ipu+1):
    # 현재 수에서 1을 빼는 경우
    d[i]= d[i-1]+1
    if i%5==0:
        d[i]=min(d[i//5]+1,d[i])
    if i%3==0:
        d[i]=min(d[i//3]+1,d[i])
    if i%2==0:
        d[i]=min(d[i//2]+1,d[i])
    
print(d[ipu])
    
