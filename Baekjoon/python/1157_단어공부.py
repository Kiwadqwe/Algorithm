import sys

input=sys.stdin.readline

n=input()
alpha=[0]*26

for i in range(len(n)):
    for j in range(26):
        if ord(n[i].lower())-97 ==j:
            alpha[j]+=1

char_max=max(alpha)
# alpha 안에 char_max값의 갯수가 2이상일때
if alpha.count(char_max)>=2:
    print("?")
else:
# alpha의 가장 큰 값의 index번호 +65 알파벳으로 변경해줌
    print(chr(alpha.index(char_max)+65))