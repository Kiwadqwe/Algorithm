import sys,heapq
input = sys.stdin.readline

N = int(input())
q = []
result = []
for i in range(N):
    x = int(input())
    if x == 0:
        if len(q):
            result.append(heapq.heappop(q)[1])
        else:
            result.append(0)
    else:
        heapq.heappush(q,(abs(x),x))

print(*result,sep="\n")