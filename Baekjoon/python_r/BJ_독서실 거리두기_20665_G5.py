import sys
input = sys.stdin.readline

N,T,P = map(int,input().split())
array = []

for i in range(T):
    a,b = map(str,input().split())

    s = int(a[0:2]) * 60 + int(a[2:])
    s2 = int(b[0:2]) * 60 + int(b[2:]) 

    array.append((s,s2))

array.sort()
visited = [[False] * (N+1)] * 1261

def distance(t,s):
    minSeat = 110

    for i in range(1,N+1):
        if i == s: continue
        if visited[t][i]:
            d = abs(i-s)
            minSeat = min(minSeat,d)

    return minSeat

def seat(t):
    maxSeat = 0
    s = 0

    for i in range(1,N+1):
        if not visited[t][i]:
            d = distance(t,i)

            if maxSeat < d:
                maxSeat = d
                s = i
    return s

def go():
    for start,end in array:
        s = seat(start)
        
        for i in range(start,end):
            print(start,end,i,s)
            visited[i][s] = True
        print()
go()

result = 0
for i in range(540,1260):
    if not visited[i][P]:
        result += 1

print(result)