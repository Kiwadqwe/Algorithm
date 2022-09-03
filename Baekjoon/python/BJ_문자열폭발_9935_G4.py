import sys
input = sys.stdin.readline

a = input().strip()
b = list(input().strip())

tp = []

for i in range(len(a)):
    tp.append(a[i])

    if tp[-len(b):] == b:
        del tp[-len(b):]
        
if tp:
    print("".join(tp))
else:
    print("FRULA")