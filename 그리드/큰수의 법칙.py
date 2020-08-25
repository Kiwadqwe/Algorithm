n,m,k = map(int, input().split())
ipu = list(map(int, input().split()))

ipu.sort()

j=0
hap=0

# while True:
#     if j!=m-1:
#         for i in range(k):
#             hap = hap+ipu[n-1]
#             j+=1
#     hap=hap+ipu[n-2]
#     j+=1

#     if j==m:
#         break     
# print(hap)

count = int(m/(k+1))*k
count += m%(k+1)

result =0
result +=(count) * ipu[n-1]
result +=(m-count) * ipu[n-2]
print(result)
