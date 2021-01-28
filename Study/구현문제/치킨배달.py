from itertools import combinations

n,m = map(int,input().split())

house=[]
chicken=[]

for i in range(n):
    array = list(map(int,input().split()))
    for j in range(n):
        if array[j]==2:
            chicken.append((i,j))
        elif array[j]==1:
            house.append((i,j))

loads = list(combinations(chicken,m))

def load_sum(load):
    hap=0
    temp=0
    for hx,hy in house:
        temp=1e9
        for cx,cy in chicken:
            temp=min(temp,abs(hx-cx)+abs(hy-cy))
        hap+=temp
    return hap

hap = 1e9
for i in loads:
    hap = min(hap, load_sum(i))

print(hap)