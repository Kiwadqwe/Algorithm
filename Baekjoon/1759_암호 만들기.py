import sys
from itertools import combinations
input = sys.stdin.readline

l,c = map(int,input().split())
array = sorted(list(map(str,input().split())))
secret = []
result = []
cm = list(combinations(array,l))

for i in range(len(cm)):
    cnt,cnt2 = 0,0
    for j in range(l):
        if cm[i][j] in 'aeiou':
            cnt+=1
        else:
            cnt2+=1
    
    if cnt>=1 and cnt2>=2:
        secret.append((cm[i]))

for i in range(len(secret)):
    result.append(''.join(secret[i]))

for re in result:
    print(re)

# 4 6
# a t c i s w

# acis
# acit
# aciw
# acst
# acsw
# actw
# aist
# aisw
# aitw
# astw
# cist
# cisw
# citw
# istw