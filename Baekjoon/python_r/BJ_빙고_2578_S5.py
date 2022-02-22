import sys
input = sys.stdin.readline

array = [list(map(int,input().split())) for _ in range(5)]
s = [list(map(int,input().split()) for _ in range(5))]

def search(s):
    for i in range(5):
        for j in range(5):
            if array[i][j] == s:
                array[i][j] = 0
                return
def check():
    cnt = 0
    check = False
    # 가로
    for i in range(5):
        for j in range(5):
            if array[i][j] == 0:
                check = True
            else:
                check = False
                break

        if check:
            cnt +=1
    
    if 3 <= cnt:
        return cnt

    # 대각선
    for i in range(5):
        if array[i][i] == 0:
            check = True
        else:
            check = False
            break

    if check:
        cnt+=1
    if 3 <= cnt:
        return cnt
    # 대각선
    for i in range(5):
        if array[i][4-i] == 0:
            check = True
        else:
            check = False
            break
    if check:
        cnt+=1
    if 3 <= cnt:
        return cnt
    # 세로
    for i in range(5):
        for a in array:
            if a[i] == 0:
                check = True
            else:
                check = False
                break

        if check:
            cnt +=1

    return cnt

count = 0
cnt = 0

for ss in s:
    for aa in ss:
        for a in aa:
            count+=1
            search(a)
            cnt = check()
            if 3 <= cnt:
                c = True
                print(count)
                exit()