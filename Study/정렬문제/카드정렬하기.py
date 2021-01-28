import heapq

n= int(input())
heap=[]

for i in range(n):
    array=int(input())
    heapq.heappush(heap,array)

result=0

while True:
    if len(heap)==1:
        break
    # 카드 하나씩 변수에 저장
    first=heapq.heappop(heap)
    second=heapq.heappop(heap)
    # sum_value heappop한 변수를 더한다
    sum_value= first+second
    # result에 저장
    result+= sum_value
    # 현재 힙이 1개 이므로 반복문을 벗어나기 때문에 힙에 하나를 더 저장시켜준다.
    heapq.heappush(heap,result)

print(result)
