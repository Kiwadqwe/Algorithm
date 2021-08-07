import sys
input = sys.stdin.readline

n,m,l = map(int,input().split())
cnt = [1]+[0 for _ in range(n-1)]
# 1~N 까지 시계 방향
ball = 0

while True:
    if cnt[ball] == m:
        break
    else:
        if cnt[ball] % 2==0 :
            if ball-l < 0:
                ball = ball-l+n
            else:
                ball = ball-l
        else:
            if n <= ball+l:
                ball = ball+l-n
            else:
                ball = ball+l

        cnt[ball] += 1

print(sum(cnt)-1)

# 5 3 2

# 10