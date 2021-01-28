n = int(input())

array= list(map(int,input().split()))

array.sort()
middle=int((array[0]+array[n-1])/2)

print(middle)