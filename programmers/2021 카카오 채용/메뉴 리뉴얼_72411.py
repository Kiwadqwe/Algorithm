from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    
    for c in course:
        array = []
        
        for o in orders:
            for comb in combinations(o,c):
                array.append(''.join(sorted(comb)))
        
        s = Counter(array).most_common()
        
        for x,y in s:
            if 2 <= y and y == s[0][1]:
                answer.append(x)
    
    answer.sort()
    
    return answer
        
print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]))
print(solution(	["XYZ", "XWY", "WXA"], [2, 3, 4]))