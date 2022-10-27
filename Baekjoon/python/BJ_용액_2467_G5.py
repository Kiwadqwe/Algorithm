import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int,input().split()))

s,e,near = 0,N-1,2147483647
result_s,result_e = 0,0

while s < e:
    hap = abs(array[s]+array[e])
    
    if hap < near:
        result_s = s
        result_e = e
        near = hap
        
        if abs(array[s]+array[e-1]) < abs(array[s+1]+array[e]):
            e-=1
        else:
            s+=1
    else:
        if abs(array[s]+array[e-1]) < abs(array[s+1]+array[e]):
            e-=1
        else:
            s+=1
        
print(array[result_s],array[result_e])