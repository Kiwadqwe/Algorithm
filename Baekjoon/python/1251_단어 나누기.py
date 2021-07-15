import sys
input = sys.stdin.readline

s = input().strip()
result = 'z' * 51

for i in range(1,len(s)):
    for j in range(i+1,len(s)):
        a = s[:i][::-1]
        b = s[i:j][::-1]
        c = s[j:][::-1]
        result = min(result,a+b+c)
        
print(result)

# mobitel

# bometil