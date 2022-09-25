import math

def go(n,k):
    s = ""
    
    while True:
        if n < k:
            return str(n)+s
        
        t = n % k
        s = str(t)+s
        n//=k

def cal(n):

    for i in range(2,int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    
    return True

def solution(n, k):
    answer = 0
    if k != 10:
        t = go(n,k)
    else:
        t = str(n)
        
    array = t.split("0")

    for a in array:
        if len(a) != 0 and a != '1' and cal(int(a)):        
            answer+=1
            
    return answer

# print(solution(437674, 3))
print(solution(110011, 10))