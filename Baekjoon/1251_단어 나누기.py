import sys
input = sys.stdin.readline

s = list(input().strip())
tp = []

for i in range(len(s)-1):
    for j in range(i+1,len(s)):
        a=s[:i]
        b=s[i:j]
        c=s[j:]
        if len(a) and len(b) and len(c):
            a.reverse()
            b.reverse()
            c.reverse()
            tp.append(a+b+c)
result = []

for t in tp:
    result.append(''.join(t))
result = sorted(result)
print(result[0])

# mobitel

# bometil