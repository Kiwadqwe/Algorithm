def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start+end)//2

    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)
    else:
        return binary_search(array, target, mid+1, end)


n = int(input())
array = list(map(int, input().split()))
array.sort()
m = int(input())
target = list(map(int, input().split()))

# 반복문을 사용하여 target의 인덱스 0번부터 i에 저장
for i in target:
    result = binary_search(array, i, 0, n-1)
    if result == None:
        print("no", end=' ')
    else:
        print("yes", end=' ')
        # print(result+1, end=' ')
