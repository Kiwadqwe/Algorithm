import sys
input = sys.stdin.readline

N = int(input())

array = [int(input()) for _ in range(N)]

s,e = 0,1
result = 0
a_sum = array[0]
b_sum = sum(array)-array[0]

while e < N:
    result = max(result,min(a_sum,b_sum))
    
    if a_sum < b_sum:
        b_sum-=array[e]
        a_sum+=array[e]
        e+=1
    else:
        a_sum-=array[s]
        b_sum+=array[s]
        s+=1
        
print(result)