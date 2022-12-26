array = [0,2,4,6,8,10,12,14,16,18]

def binary_search(target,s,e):
    if e < s:
        return
    m = (s+e)//2
    
    if array[m] == target:
        return m
    elif target < array[m]:
        return binary_search(target,s,m-1)
    else:
        return binary_search(target,m+1,e)
    
print(binary_search(4,0,len(array)-1))
    
s,e = 0,len(array)-1
target = 4
while s <= e:
    m = (s+e)//2
    
    if array[m] == target:
        print(m)
        break
    elif target < array[m]:
        e = m-1
    else:
        s = m+1