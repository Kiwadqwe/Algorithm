from collections import Counter

def solution(str1, str2):
    a,b = [],[]
    str1 = str1.lower()
    str2 = str2.lower()
    
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            a.append(str1[i]+str1[i+1])
        
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            b.append(str2[i]+str2[i+1])
    
    c1 = Counter(a)
    c2 = Counter(b)
    
    iters = list((c1 & c2).elements())
    uin = list((c1 | c2).elements())
    
    if not len(iters) and not len(uin):
        return 65536
    else:
        return int(len(iters)/len(uin) * 65536)

# print(solution("FRANCE", "french"))
# print(solution("handshake", "shake hands"))
print(solution("aa1+aa2", "AAAA12"))
# print(solution("E=M*C^2", "e=m*c^2"))