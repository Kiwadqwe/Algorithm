import sys,copy
input = sys.stdin.readline

N = int(input())
S = list(map(str,input().strip()))
cnt = 0

for _ in range(N-1):
    A = list(map(str,input().strip()))
    temp = copy.copy(S)
    
    if 2 <= abs(len(A)-len(S)): continue
    
    for _ in range(len(A)):
        t = A.pop(0)
        
        if t in temp:
            temp.remove(t)
        else:
            A.append(t)
            
    if (2 <= len(temp) and 1 <= len(A)) or (1 <= len(temp) and 2<=len(A)): continue
        
    if len(A) == len(temp) or abs(len(A)-len(temp)) == 1:
        cnt+=1 

print(cnt)