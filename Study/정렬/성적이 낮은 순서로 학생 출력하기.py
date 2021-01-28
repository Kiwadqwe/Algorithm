n = int(input())

array = []

for i in range(n):
    data_ipu = input().split()
    array.append((data_ipu[0],int(data_ipu[1])))
array =sorted(array, key=lambda result:result[1])
print(array)

for result in array:
    print(result[0], end=' ')
