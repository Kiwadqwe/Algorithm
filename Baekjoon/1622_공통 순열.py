import sys
input = sys.stdin.readline
result = []

while True :
    try :
        a=input().strip()
        b=input().strip()
    except :
        break
    ans = ""
    s = "abcdefghijklmnopqrstuvwxyz"
    for i in s :
        cnt = min(a.count(i), b.count(i))
        ans += i*cnt
print(ans)
