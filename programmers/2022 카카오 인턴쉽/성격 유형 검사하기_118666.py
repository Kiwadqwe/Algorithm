def solution(survey, choices):
    answer = ''
    score = [0,3,2,1,0,1,2,3]
    d = {'R' : 0, 'T' : 0 , 'C' : 0 , 'F' : 0, 'J' : 0,'M': 0, 'A': 0, 'N': 0}
    l = len(survey)
    c = ["RT","CF","JM","AN"]
    check = [False] * 4
    result = []
    
    for i in range(l):
        a = survey[i][0]
        b = survey[i][1]
        
        if  choices[i] < 4:
            d[a] += score[choices[i]]
            
        elif 4 < choices[i]:
            d[b] += score[choices[i]]
    print(d)
    answer = sorted(d.items(), key = lambda x : (-x[1],x[0]))
    
    for i in range(len(answer)):
        for j in range(len(c)):
            if answer[i][0] in c[j] and not check[j]:
                check[j] = True
                result.append(answer[i][0])
                break
        
        
    print(answer)
    return answer

print(solution(	["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5]))