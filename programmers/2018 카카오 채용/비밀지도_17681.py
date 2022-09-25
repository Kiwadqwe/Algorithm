def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        s = bin(arr1[i] | arr2[i])[2:]
        s = s.rjust(n,'0')
        s = s.replace('1',"#")
        s = s.replace('0'," ")
        answer.append(s)
    
    return answer

print(solution(6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]))