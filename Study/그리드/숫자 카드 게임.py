n,m = map(int, input().split())

save=0

for i in range(n):
    ipu = list(map(int, input().split()))
    temp = min(ipu)
    save = max(temp,save)
print(save)