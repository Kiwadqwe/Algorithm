import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int,input().split()))
array.sort()
s,e = 0,N-1
result,result_s,result_e = float("INF"),0,0

for i in range(N-1):
    s = i+1
    e = N-1
    
    while s <= e:
        m = (s+e) // 2
        hap = abs(array[i]+array[m])
        
        if hap < result:
            result = hap
            result_s = i
            result_e = m
            
            if result == 0:
                print(array[result_s],array[result_e])
                sys.exit(0)
            
            if i+1<=m<N-1 and abs(array[m+1]+array[i]) < abs(array[i]+array[m-1]):
                s = m+1
            else:
                e = m-1
        else:
            if i+1<=m<N-1 and abs(array[m+1]+array[i]) < abs(array[i]+array[m-1]):
                s = m+1
            else:
                e = m-1
            
        
print(array[result_s],array[result_e])