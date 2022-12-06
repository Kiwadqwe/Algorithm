# import sys, heapq
# input = sys.stdin.readline

# T = int(input())
# result = []
# for t in range(T):
#     N = int(input())
#     max_q,min_q = [],[]

#     for i in range(N):
#         x,y = map(str,input().split())
#         if x == 'I':
#             heapq.heappush(max_q,(-int(y),int(y)))
#             heapq.heappush(min_q,(int(y)))
#         else:
#             if y == '1' and len(max_q):
#                 m = heapq.heappop(max_q)[1]
#                 min_q.remove(m)
#             elif y == '-1' and len(min_q):
#                 m = heapq.heappop(min_q)
#                 max_q.remove((-m,m))
                
#     if not len(max_q) and not len(min_q):
#         print("EMPTY")
#     elif not len(max_q) and len(min_q):
#         print("EMPTY",heapq.heappop(min_q))
#     elif len(max_q) and not len(min_q):
#         print(heapq.heappop(min_q),"EMPTY")
#     else:
#         print(heapq.heappop(max_q)[1],heapq.heappop(min_q))

import sys, heapq
input = sys.stdin.readline

T = int(input())

result = []

for t in range(T):
    N = int(input())
    q = []

    for i in range(N):
        x,y = map(str,input().split())
        
        if x == 'I':
            heapq.heappush(q,int(y))
        else:
            if not len(q): continue
            if y == '-1':
                heapq.heappop(q)
            else:
                q = heapq.nlargest(len(q),q)[1:]
                heapq.heapify(q)
    if q:
        print(max(q),min(q))
    else:
        print("EMPTY")