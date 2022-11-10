import sys
input = sys.stdin.readline

S = input().rstrip()

zero = S.count('0')
one = S.count('1')

if one == len(S) or zero == len(S):
    print(0)
    sys.exit(0)
else:
    o,z = 0,0
    if S[0] == '0':
        z+=1
    else:
        o+=1
    for i in range(1,len(S)):
        if S[i-1] != S[i]:
            if S[i] == '1':
                o+=1
            else:
                z+=1

print(min(z,o))