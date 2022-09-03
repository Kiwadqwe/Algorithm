
def solution(progresses, speeds):
    cnt = 0
    d = 1
    result = []
    
    while progresses:
        if 100 <= progresses[0] + speeds[0] * d:
            progresses.pop(0)
            speeds.pop(0)
            cnt +=1
        else:
            if cnt:
                result.append(cnt)
                cnt = 0
            d+=1
            
    result.append(cnt)
    return result

print(solution([93,30,55],[1,30,5]))