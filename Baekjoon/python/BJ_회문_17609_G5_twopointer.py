import sys
input = sys.stdin.readline

T = int(input())
result = []

def check2(S,start,end):
    while start<end:
        if S[start] == S[end]:
            start+=1
            end-=1
        else: return False
    return True

def check(S,start,end):
    while start<end:
        if S[start] == S[end]:
            start+=1
            end-=1
        else:
            if check2(S,start+1,end) or check2(S,start,end-1):
                return 1
            else:
                return 2
    return 0

for i in range(T):
    S = input().strip()

    result.append(check(S,0,len(S)-1))

for r in result:
    print(r)