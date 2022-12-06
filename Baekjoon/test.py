from bisect import bisect_left, bisect_right
from collections import Counter
import sys
# array = [1,2,3,4,5,6]



# S = '567'
# result = int(S[0])
# for i in range(len(S)-1):
#     if S[i] == '0' or S[i] == '1':
#         result+=int(S[i+1])
#     else:
#         result*=int(S[i+1])
# print(result)

# print(bisect_left(array,5))
# print(bisect_right(array,7))
# c = Counter(array).elements()
# print(c)
# N,M = 2,15
# array = [2,3]

# dp = [10001] * 16
# dp[2] = 1
# dp[3] = 1
# for i in range(4,16):
#     for j in array:
#         dp[i] = min(dp[i-j]+1, dp[i])

# print(dp[15])

# array = [[1,2,3],[4,5,6],[7,8,9]]

# def dfs(x,y):
    
#     if x <= -1 or x >= 5 or y <= -1 or y >= 5:
#         return False
    
#     if array[x][y]:
#         array[x][y] = 0
        
#         dfs(x-1,y)
#         dfs(x,y-1)
#         dfs(x+1,y)
#         dfs(x,y+1)
#         return True
    
#     return False

# dfs(0,0)


# for i in range(1,len(array)):
#     for j in range(i,0,-1):
#         if array[j] < array[j-1]:
#             array[j],array[j-1] = array[j-1],array[j]
#         else:
#             break
        
# print(array)
