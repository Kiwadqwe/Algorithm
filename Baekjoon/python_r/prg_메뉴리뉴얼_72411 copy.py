from itertools import combinations as comb
from collections import Counter

def solution(orders, course):
    answer = []

    for c in course:
        array = []
        
        for o in orders:
            for cb in comb(o,c):
                array.append(''.join(sorted(cb)))
        
        # 각 문자의 개수를 세고 내림차순으로 정렬한다.
        s = Counter(array).most_common()

        for x,y in s:
            if 2 <= y and y == s[0][1]:
                answer.append(x)
    
    answer.sort()
    
    return answer
            

print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]))