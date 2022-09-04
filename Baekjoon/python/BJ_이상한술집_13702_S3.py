import sys
input = sys.stdin.readline

N,K = map(int,input().split())
array = [int(input()) for _ in range(N)]
start,end = 1,max(array)
result = 0

while start <= end:
    mid = (start+end)//2
    cnt = 0
    
    for a in array:
        cnt+=a//mid
    
    # 무조건 분배해야되므로 K보다 클때도 결과값 갱신
    if K <= cnt:
        result = mid
        start = mid+1
    else:
        end = mid-1
        
print(result)