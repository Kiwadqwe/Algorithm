import sys
input = sys.stdin.readline
result = []

while True:
    a=input().strip()
    if not a:
        break
    b=input().strip()
    tp=[]

    for i in range(len(a)):
        if a[i] in b:
            tp.append(a[i])
            b=b.replace(a[i],"",1)
    tp.sort()
    result.append("".join(tp))

for re in result:
    print(re)