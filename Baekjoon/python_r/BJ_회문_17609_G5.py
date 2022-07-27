import sys
input = sys.stdin.readline

N = int(input())
result = []

def twoPointer(a,start,end):
    while start < end:
        if a[start] == a[end]:
            start+=1
            end-=1
        else:
            return False
    return True

for _ in range(N):
    a = input().strip()
    start,end,cnt = 0,len(a)-1,0

    check = True   
    while start < end:
        if a[start] != a[end]:
            if not cnt:
                if twoPointer(a,start+1,end) or twoPointer(a,start,end-1):
                    cnt+=1
                    break 
                else:
                    check = False
                    break
            else:
                check = False
                break
        else:
            start+=1
            end-=1
    
    if check and cnt == 1:
        result.append(1)
    elif check:
        result.append(0)
    elif not check:             
        result.append(2)

print(*result, sep="\n")