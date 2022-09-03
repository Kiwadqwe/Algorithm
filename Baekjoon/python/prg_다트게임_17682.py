def solution(dartResult):
    d = {"S": 1, "D": 2, "T":3}
    t = ""
    array = []
    
    for k in dartResult:
        if k.isnumeric():
            t += k
        elif k in d.keys():
            array.append(int(t) ** d.get(k))
            t = ""
        elif k  == "*":
            if 2 <= len(array):
                array[-2] = array[-2] * 2 
            array[-1] = (array[-1] * 2)
        elif k == "#":
            array[-1] = -array[-1]
            
    return sum(array)

print(solution("1D2S3T*"))