# import sys

# N,M = 5,4
# array = [[0,1,0,1,1],[1,0,1,1,0],[0,1,0,0,0],[1,1,0,0,0],[1,0,0,0,0]]
# t = [1,2,3,2]
# p = [i for i in range(N+1)]
# def union(x,y):
#     a = find(x)
#     b = find(y)
    
#     if a < b:
#         p[b] = a
#     else:
#         p[a] = b
        
# def find(x):
#     if x != p[x]:
#         p[x] = find(p[x])
#     return p[x]

# for i in range(N):
#     for j in range(N):
#         if array[i][j] == 1:
#             union(i,j)

# for i in range(len(t)-1):
#     if find(i) != find(i+1):
#         print("NO")
#         sys.exit(0)

# print("YES")

print(90-90%1)