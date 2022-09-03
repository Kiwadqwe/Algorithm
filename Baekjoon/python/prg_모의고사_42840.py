def solution(answers):
    n = [[1,2,3,4,5],[2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]]
    d = {x+1 : 0 for x in range(len(n))}
    
    for i in range(len(answers)):
        for j in range(3):
            if n[j][i%len(n[j])] == answers[i]:
                d[j+1] = d.get(j+1)+1
            
    result = []
    m = max(d.values())
    d = sorted(d.items(), key = lambda x : (-x[1],x[0]))
    for i in range(len(d)):
        if d[i][1] == m:
            result.append(d[i][0])
    
    return result

print(solution([1,2,3,4,5]))