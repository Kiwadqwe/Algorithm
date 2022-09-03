def go(n,a1,a2):
    array = []
    
    for i in range(n):
        a = bin(a1[i]| a2[i])[2:]
        a = a.rjust(n,"0")
        a = a.replace("1","#")
        a = a.replace("0"," ")
        array.append(a)
        
    return array


def solution(n, arr1, arr2):
    
    array = go(n,arr1,arr2) 
    
    return array


print(solution(5,[9, 20, 28, 18, 11],[30, 1, 21, 17, 28]))


def go(n,a1,a2):
    array = [""] * n
    
    for i in range(n):
        a = bin(a1[i])[2:]
        b = bin(a2[i])[2:]
        if len(a) < n:
            a = ("0"* (n-len(a)))+a

        if len(b) < n:
            b = ("0"* (n-len(b)))+b
            
        for j in range(n):            
            if a[j] == "1" or b[j] == "1":
                array[i] += "#"
            else:
                array[i] += " "
    return array


def solution(n, arr1, arr2):
    
    array = go(n,arr1,arr2) 
    
    return array