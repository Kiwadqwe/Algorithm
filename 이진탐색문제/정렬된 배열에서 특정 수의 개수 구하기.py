n,x = map(int,input().split())
array = list(map(int,input().split()))

cnt=0

def binary_search(array,target,start,end):
    global cnt
    if start>end:
        return cnt
    if array[end]==target:
        cnt+=1
        return binary_search(array,target,start,end-1)
    else:
        return binary_search(array,target,start,end-1)

    if array[start]==target:
        cnt+=1
        return binary_search(array,target,start+1,end)
    else:    
        return binary_search(array,target,start+1,end)

binary_search(array,x,0,n-1)
if cnt==0:
    print("-1")
else:
    print(cnt)