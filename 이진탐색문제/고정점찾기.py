n = int(input())
array = list(map(int,input().split()))

temp=0

def binary_search(array,start,end):
    global temp
    if start>end:
        return None
    mid = (start+end)//2
    if array[mid]==mid:
        temp=mid
        return mid
    # 중간값이 target보다 작은 경우 mid+1
    elif array[mid]< mid:
        return binary_search(array,mid+1,end)
    else:
        return binary_search(array,start,mid-1)

result = binary_search(array,0,n-1)

if result!=temp:
    print("-1")
else:
    print(result)
    
    
