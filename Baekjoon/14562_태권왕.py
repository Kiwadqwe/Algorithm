import sys
input = sys.stdin.readline

c = int(input())
result = []

def score(x,y,cnt):
    global tp

    if x > y:
        return
    elif x == y:
        tp = min(tp,cnt)
        return 
    else:
        score(x*2,y+3,cnt+1)
        score(x+1,y,cnt+1)

for _ in range(c):
    s,t = map(int,input().split())
    cnt = 0
    tp = 10001
    score(s,t,cnt)
    result.append(tp)

for re in result:
    print(re)


# 6
# 10 20
# 2 7
# 15 62
# 10 37
# 11 50
# 34 59

# 3
# 3
# 4
# 4
# 5
# 25