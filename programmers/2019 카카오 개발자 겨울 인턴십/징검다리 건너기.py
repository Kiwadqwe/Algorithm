def solution(stones, k):
    answer = 0
    s,e = 1,max(stones)
    
    while s<=e:
        friends = (s+e)//2
        cnt = 0
        
        for stone in stones:
            if stone <= friends:
                cnt += 1
            else:
                cnt = 0
            
            if k <= cnt: break
        
        if k <= cnt:
            e = friends-1
        else:
            s = friends+1

    return s

print(solution(	[2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3))