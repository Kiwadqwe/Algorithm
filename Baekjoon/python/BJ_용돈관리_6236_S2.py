import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [int(input()) for _ in range(N)]

max_ = max(array)
min_ = min(array)
sum_ = sum(array)
result = int(1e9)

while min_ <= sum_:
    m = (min_+sum_)//2
    
    if m < max_:
        min_+=1
        continue
    
    money = m
    k = 1
    
    for i in range(N):
        if money < array[i]:
            money = m
            k+=1
            
        money -= array[i]

    if M < k:
        min_ = m+1
    else:
        result = min(result,m)
        sum_ = m-1
        
print(result)

