import sys
input = sys.stdin.readline

N,M = map(int,input().split())

array = [list(map(int,input().strip())) for _ in range(N)]

result = []

for i in range(1 << N*M):
    hap = 0
    
    for x in range(N):
        x_hap = 0
        for y in range(M):
            idx = x*M + y
            if i & (1<<idx) != 0:
                x_hap = x_hap * 10 + array[x][y]
            else:
                hap += x_hap
                x_hap = 0
                
        hap += x_hap
    
    for y in range(M):
        y_hap = 0
        for x in range(N):
            idx = x*M + y
            if i & (1<<idx) == 0:
                y_hap = y_hap * 10 + array[x][y]
            else:
                hap += y_hap
                y_hap = 0
        hap += y_hap
        
    result.append(hap)

print(max(result))
            