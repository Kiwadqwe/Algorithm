def solution(id_list, report, k):
    d = {x:0 for x in id_list}
    p = {x:[] for x in id_list}
    result = {x:0 for x in id_list}
    report = list(set(report))
    
    for r in report:
        x,y = r.split()
        d[y]+=1
        p[y].append(x)
        
        
    for x,y in d.items():
        if k <= y:
            for t in p[x]:
                result[t]+=1

    return  list(result.values())

# print(solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"], 2))
print(solution(	["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3))