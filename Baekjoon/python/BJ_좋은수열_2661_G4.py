import sys
input = sys.stdin.readline

N = int(input())
array = []

def check(K):
    global array
    
    # 1,2,1,2
    # 1) 2:3, 3:
    # 2) 0:2, 2:
    for i in range(1,K):
        x = K-i-i
        y = K-i
        a = array[K-i-i:K-i]
        b = array[K-i:]
        if a == b:
            return False
    return True
            
def go(K):
    global array
    
    if K == N:
        print(''.join(map(str,array)))
        sys.exit(0)
    
    for i in range(1,4):
        array.append(i)

        if check(K+1):
            go(K+1)
        
        array.pop()        
        

go(0)