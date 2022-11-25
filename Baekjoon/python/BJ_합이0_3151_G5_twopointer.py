from collections import Counter
import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int,input().split()))
array.sort()
counter = Counter(array)
result = 0

for i in range(N-2):
    s = i+1
    e = N-1
    
    while s < e:
        a,b,c = i,s,e
        hap = array[i]+array[s]+array[e]
        
        if hap == 0:
            # 같으면 e랑 s 사이도 다 같으니
            if array[e] == array[s]:
                result+=e-s
            else:
                k = counter[array[e]]
                # 현재 s 위치에서 array[e]가 같은 개수 다 더하기
                result+=counter[array[e]]
            s+=1
        elif hap < 0:
            s+=1
        elif 0 < hap:
            e-=1
        
print(result)