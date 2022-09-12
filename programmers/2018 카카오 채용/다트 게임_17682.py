def solution(dartResult):
    alpha = {"S": 1 , "D": 2, "T": 3}
    t = ""
    array = []
    
    for d in dartResult:
        if d.isnumeric():
            t += d        
        elif d in alpha.keys():
            array.append(int(t) ** alpha.get(d))
            t = ""
        elif d == "*":
            if 2 <= len(array):
                array[-2] = array[-2] * 2
            array[-1] = array[-1] * 2
        elif d == "#":
            array[-1] = -array[-1]
            
    return sum(array)

print(solution("1S2D*3T"))