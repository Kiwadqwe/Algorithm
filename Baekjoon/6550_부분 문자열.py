import sys
input = sys.stdin.readline

result = []

while True:
    try:
        s,t = map(str,input().split())
    except:
        break

    check = False
    tp = 0
    for j in range(len(t)):
        if s[tp] == t[j]:
            tp+=1
            if tp == len(s):
                check = True
                break
    if check:
        result.append('Yes')
    else:
        result.append('No')

for re in result:
    print(re)

# sequence subsequence
# person compression
# VERDI vivaVittorioEmanueleReDiItalia
# caseDoesMatter CaseDoesMatter

# Yes
# No
# Yes
# No