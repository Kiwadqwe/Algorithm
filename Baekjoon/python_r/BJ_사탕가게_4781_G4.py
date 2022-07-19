def solution(N,M,array):
    dp = [0] * (M+1)
    
    for w,v in array:
        for i in range(v,M+1):
            dp[i] = max(dp[i],dp[i-v]+w)
            
    return max(dp)

def ipu():
    result = []
    
    while True:
        N,M = map(float,input().split())
        N,M = int(N),int(M * 100 + 0.5)
        
        if N == 0 and M == 0.00:
            print(*result, sep="\n")
            return
        
        array = []
        for _ in range(N):
            a,b = map(float,input().split())
            
            array.append((int(a),int(b * 100 + 0.5)))

        result.append(solution(N,M,array))
        
ipu()