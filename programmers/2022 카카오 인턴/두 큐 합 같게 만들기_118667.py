def solution(queue1, queue2):
    answer = 0
    hap = sum(queue1)
    l = len(queue1) * 2
    q3 = queue1+queue2
    s,e = 0,len(queue1)
    result = (hap+sum(queue2))//2
    
    while hap != result:
        if hap < result:
            hap+=q3[e]
            e += 1
        elif result < hap:
            hap-=q3[s]
            s+=1

        answer+=1

        if e == l:
            return -1
        
    return answer

print(solution(	[3, 2, 7, 2], [4, 6, 5, 1]))
print(solution(	[1, 2, 1, 2], [1, 10, 1, 2]))
print(solution([1, 1], [1, 5]))