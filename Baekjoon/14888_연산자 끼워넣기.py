import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))
a, b, c, d = map(int, input().split())
hap = a+b+c+d
result = array[0]
mi,ma = 1e9,-1e9

def cal(a, b, c, d, cnt,result):
    global hap,mi,ma
    
    if cnt == hap+1:
        ma = max(result,ma)
        mi = min(result,mi)
        return
    
    if a:
        cal(a-1, b, c, d, cnt+1,result+array[cnt])
    if b:
        cal(a, b-1, c, d, cnt+1,result-array[cnt])
    if c:
        cal(a, b, c-1, d, cnt+1,result*array[cnt])
    if d:
        cal(a, b, c, d-1, cnt+1,int(result/array[cnt]))

cal(a, b, c, d, 1,result)

print(ma)
print(mi)