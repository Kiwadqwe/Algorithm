import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

V,E = map(int,input().split())
repres = [i for i in range(V+1)]
array = []
edgeCnt = 0
hap = 0

for i in range(E):
    a,b,c = map(int,input().split())
    array.append((a,b,c))

array.sort(key = lambda x:x[2])

def unin(f, to):
    a = find(f)
    repres[a] = find(to)

def find(a):
    if repres[a] != a:
        repres[a] = find(repres[a])
    return repres[a]

for i in range(E):
    f = array[i][0]
    to = array[i][1]
    dis = array[i][2]

    if find(f) != find(to):
        unin(f, to)
        hap += dis        

print(hap)