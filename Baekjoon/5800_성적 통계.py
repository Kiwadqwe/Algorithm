import sys
input = sys.stdin.readline
k = int(input())

for i in range(k):
    array = list(map(int,input().split()))
    del array[0]
    array.sort(reverse = True)
    larg = 0

    for j in range(1,len(array)):
        larg = max(larg,array[j-1]-array[j])

    print('Class',i+1)
    print('Max', str(max(array))+',' ,'Min', str(min(array))+',', 'Largest gap', larg)

# 2
# 5 30 25 76 23 78
# 6 25 50 70 99 70 90

# Class 1
# Max 78, Min 23, Largest gap 46
# Class 2
# Max 99, Min 25, Largest gap 25