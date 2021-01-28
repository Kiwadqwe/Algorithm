ipu = int(input())
array = []

for i in range(ipu):
    array.append(int(input()))

array = sorted(array, reverse=True)

for i in array:
    print(i, end=' ') # 정렬이 완료된 데이터를 출력

print(array) # 리스트로 출력