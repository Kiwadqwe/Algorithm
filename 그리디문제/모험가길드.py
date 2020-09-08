n = int(input())

ipu = list(map(int,input().split()))
ipu.sort()
group=0
cnt=0

for i in ipu:
    cnt+=1
    if cnt>=i:
        group+=1
        cnt=0
print(group)