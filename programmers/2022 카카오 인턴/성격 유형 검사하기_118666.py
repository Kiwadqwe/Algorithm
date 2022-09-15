def check(x,y,d,answer):
    
    if d[x] < d[y]:
        answer.append(y)
    else:
        answer.append(x)

def solution(survey, choices):
    answer = []
    score = [0,3,2,1,0,1,2,3]
    d = {'R' : 0, 'T' : 0 , 'C' : 0 , 'F' : 0, 'J' : 0,'M': 0, 'A': 0, 'N': 0}
    l = len(survey)
    
    for i in range(l):
        a = survey[i][0]
        b = survey[i][1]
        
        if  choices[i] < 4:
            d[a] += score[choices[i]]
            
        elif 4 < choices[i]:
            d[b] += score[choices[i]]
    
    check('R','T',d,answer)
    check('C','F',d,answer)
    check('J','M',d,answer)
    check('A','N',d,answer)

    return "".join(answer)

print(solution(["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5]))