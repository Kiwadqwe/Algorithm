def solution(n, arr1, arr2):
    answer = [''] * n
    for i in range(n):
        arr1[i] = format(arr1[i],'b')
        arr2[i] = format(arr2[i],'b')
        if len(arr1[i]) < n:
            for k in range(n-len(arr1[i])):
                arr1[i] ='0'+arr1[i]
        if len(arr2[i]) < n:
            for k in range(n-len(arr2[i])):
                arr2[i] ='0'+arr2[i] 

        for j in range(n):
            if arr1[i][j] == '1' or arr2[i][j] == '1':
                answer[i] += '#'
            else:
                answer[i] += ' '
    return answer

# def solution(n, arr1, arr2):
#     answer = []
#     for i,j in zip(arr1,arr2):
#         a = str(bin(i|j)[2:])
#         a = a.rjust(n,'0')
#         a = a.replace('1','#')
#         a = a.replace('0', ' ')
#         answer.append(a)
#     return answer

# n	5
# arr1	[9, 20, 28, 18, 11]
# arr2	[30, 1, 21, 17, 28]
# 출력	["#####","# # #", "### #", "# ##", "#####"]