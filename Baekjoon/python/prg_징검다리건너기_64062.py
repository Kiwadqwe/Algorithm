def solution(stones, k):
    answer = 1
    l = len(stones)

    check = True
    while True:
        start,end = 0,l-1
        
        while start <= end:
            m = (start+end)//2
            
            if stones[end] and stones[start]:
                stones[end]-=1
                end-=1
                stones[start]-=1
                start+=1
            elif not stones[end]:
                for i in range(1,k+1):
                    if stones[end-i]:
                        end -= i
                        break
            elif not stones[start]:
                for i in range(1,k+1):
                    if stones[start+i]:
                        start+= i
                        break
            
        if not check:
            break
        
        answer+=1
        
    return answer

print(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1],3))