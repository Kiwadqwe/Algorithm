import sys
input = sys.stdin.readline

n,m = map(int,input().split())
# 시간을 줄이기 위해서 set 사용
s = set()

for i in range(n):
    s.add(str(input().strip()))

cnt = 0;
for i in range(m):
    if input().strip() in s:
        cnt+=1 
        
print(cnt)

# 5 11
# baekjoononlinejudge
# startlink
# codeplus
# sundaycoding
# codingsh
# baekjoon
# codeplus
# codeminus
# startlink
# starlink
# sundaycoding
# codingsh
# codinghs
# sondaycoding
# startrink
# icerink

# 4