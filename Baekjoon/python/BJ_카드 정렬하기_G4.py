import sys,heapq
input = sys.stdin.readline

N = int(input())

q = []

for _ in range(N):
    a = int(input())
    heapq.heappush(q,(a))

result = 0
while len(q) != 1:
    hap = heapq.heappop(q)+heapq.heappop(q)
    result+=hap
    heapq.heappush(q,(hap))

print(result)