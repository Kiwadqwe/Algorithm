import sys,heapq
input = sys.stdin.readline

N = int(input())
array = [int(input()) for _ in range(N)]

result = []
max_h,min_h = [],[]

for i in range(len(array)):
    if len(max_h) == len(min_h):
        heapq.heappush(max_h,(-array[i]))
    else:
        heapq.heappush(min_h,(array[i]))
    
    # 현재 중간값이 최소힙의 최소값보다 크다면 자리 변경
    if min_h and -max_h[0] > min_h[0]:
        a = heapq.heappop(max_h)
        b = heapq.heappop(min_h)
        heapq.heappush(max_h,(-b))
        heapq.heappush(min_h,(-a))
        
    # 최대힙에 저장된 첫번째 값이 중간값
    result.append(-max_h[0])
    
print(*result, sep = "\n")