import sys
input = sys.stdin.readline

S = input().strip()
cnt = 0
count = [0] * 26

def dfs(idx, choosed):
    global cnt

    if idx == len(S):
        cnt+=1
        return
    
    for s in cSet:
        c = ord(s) - ord('a')
        if not count[c]: continue

        if choosed and choosed[-1] == s: continue

        count[c] -= 1
        dfs(idx+1, choosed+s)
        count[c] += 1

cSet = set()
for s in S:
    c = ord(s) - ord('a')
    cSet.add(s)
    count[c] = count[c]+1

dfs(0,'')
print(cnt)