def binary_search(array, target, start, end):
    # start가 end보다 크면 None출력
    if start > end:
        return None
    mid = (start+end) // 2
    if array[mid] == target:
        return mid
    # 중간값보다 target보다 큰 경우 왼쪽 확인
    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)
    # 중간값이 target보다 작은 경우 오른쪽 확인 
    else:
        return binary_search(array, target, mid+1, end)

n, target = list(map(int, input().split()))
array = list(map(int, input().split()))

result = binary_search(array, target, 0, n-1)
if result == None:
    print("원소가 존재하지 않습니다.")
else:
    print(result+1)
