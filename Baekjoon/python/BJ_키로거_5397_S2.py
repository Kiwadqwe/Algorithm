import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
result = []

for _ in range(T):
    S = input().strip()
    alpha,temp = deque(),deque()
    
    if '>' not in S and '<' not in S and '-' not in S:
        result.append(S)
        continue
    
    for i in range(len(S)):
        if S[i] == '<':
            if alpha:
                temp.append(alpha.pop())
        elif S[i] == '>':
            if temp:
                alpha.append(temp.pop())
        elif S[i] == '-':
            if alpha:
                alpha.pop()
        else:
            alpha.append(S[i])

    alpha.extend(reversed(list(temp)))
    result.append(''.join(list(alpha)))
    
print(*result,sep = "\n")