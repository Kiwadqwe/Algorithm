n = int(input())

array = []

for i in range(n):
    array.append(input().split())
# -int(x[1])는 내림차순으로 int(x[2]) 는 오름차순 
array.sort(key=lambda x:(-int(x[1]), int(x[2]), -int(x[3]),x[0]))

for i in array:
    print(i[0])