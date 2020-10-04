import sys
import heapq

input = sys.stdin.readline

array= list(map(int,input().split()))
k=int(input())

def solution(scoville, K):
    cnt=0
    heap = []

    for i in scoville:
        heapq.heappush(heap,i)

    while True:
        if heap[0]>=K:
            break
        cnt+=1
        try:
            heapq.heappush(heap,heapq.heappop(heap)+heapq.heappop(heap)*2)
        except IndexError:
            return -1
    return cnt

print(solution(array,k))