from collections import deque

def solution(queue1, queue2):
    answer = 0
    a,b = deque(queue1),deque(queue2)
    l = len(queue1) * 3
    a_sum,b_sum = sum(a),sum(b)
    
    while (a and b) and answer != l:
        if a_sum == b_sum:
            return answer
        elif a_sum < b_sum:
            t = b.popleft()
            a.append(t)
            a_sum+=t
            b_sum-=t
            answer+=1
        elif a_sum > b_sum:
            t = a.popleft()
            b.append(t)
            a_sum-=t
            b_sum+=t
            answer+=1    
    
    return -1

print(solution(	[3, 2, 7, 2], [4, 6, 5, 1]))
print(solution(	[1, 2, 1, 2], [1, 10, 1, 2]))
print(solution([1, 1], [1, 5]))