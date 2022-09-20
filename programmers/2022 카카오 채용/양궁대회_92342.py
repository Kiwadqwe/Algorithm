from itertools import combinations_with_replacement

def solution(n, info):
    answer = [-1,0,0,0,0,0,0,0,0,0,0]
    score = [0,1,2,3,4,5,6,7,8,9,10]

    # 라이언 n발
    info.reverse()
    result = 0

    for p in combinations_with_replacement(score,n):
        r = [0 for _ in range(11)]
        r_hap,a_hap = 0,0
        
        for x in range(11):
            c = p.count(x)
            r[x] = c
        
        for x in range(11):
            if not info[x] and not r[x]: continue
            
            if info[x] < r[x]:
                r_hap += x
            else:
                a_hap += x
                
        if a_hap < r_hap:
            l = r_hap-a_hap
            if result < l:
                result = l
                answer = r

    answer.reverse()
    if answer[-1] == -1:
        return [-1]
    else:
        return answer

# print(solution(5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]))
print(solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]))