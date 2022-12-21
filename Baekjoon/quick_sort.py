
array = [7,6,9,0,3,1,6,2,4,8]
def quick(start,end):
    if end <= start:
        return
    
    pivot = start
    left = start+1
    right = end
    
    while left <= right:
        
        while left <= end and array[left] <= array[pivot]:
            left += 1
        
        while start < right and array[pivot] <= array[right]:
            right -= 1
            
        if right < left:
            array[right], array[pivot] = array[pivot],array[right]
        else:
            array[left],array[right] = array[right],array[left]
            
    quick(start,right-1)
    quick(right+1,end)

quick(0,len(array)-1)
print(array)
