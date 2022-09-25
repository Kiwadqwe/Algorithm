def solution(s):
    answer = []
    
    for k in range(1,len(s)+1):
        t = s[:k]
        cnt = 1
        temp = ""
        
        for i in range(k,len(s)+k,k):
            if s[i:k+i] == t:
                cnt+=1
            else:
                if cnt == 1:
                    temp += t
                else:
                    temp += str(cnt)+t
                
                t = s[i:k+i]
                cnt = 1

        answer.append(len(temp))
        
    return min(answer)

print(solution("aabbaccc"))
print(solution("ababcdcdababcdcd"))