import sys
input = sys.stdin.readline

n = int(input())
cnt =0

for i in range(n):
    ipu = input().strip()
    for j in range(len(ipu)-1):
        if ipu[j] != ipu[j+1] and ipu[j] in ipu[j+2:]:
            cnt+=1
            break
print(n-cnt)

# 4
# aba
# abab
# abcabc
# a

# 1