n, c = map(int,input().split())
array=[]

for i in range(n):
    array.append(int(input()))
array.sort()

# 집의 좌표 중에 가장 작은 값
start = array[1]-array[0]
# 집의 좌표 중에 가장 큰 값
end = array[-1]-array[0]
while True:
    if start>end:
        break
    mid = (start+end)//2    
    value = array[0]
    count =1
    # 현재의 mid값을 이용해 공유기를 설치
    # 앞에서부터 차근차근 설치
    for i in range(1,n):
        if array[i]>=value+mid:
            value=array[i]
            count+=1
    # C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가
    if count>=c:
        start = mid+1
        # 최적의 결과를 저장
        result = mid    
    # C개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소
    else:
        end = mid-1
        
print(result)