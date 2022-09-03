import sys
input = sys.stdin.readline

S = int(input())
array = list(map(int,input().split()))

visited = [True]+[0] * (sum(array)+1)

array.sort()

hap = 1
for a in array:
    if hap < a:
        break
    hap += a
    
print(hap)
    

# for i in array:
#     visited[i] = True

# def comb(k,s,idx,choosed):
#     if idx == k:
#         if not visited[sum(choosed)]:
#             visited[sum(choosed)] = True
#         return
    
#     for i in range(s,len(array)):
#         choosed.append(array[i])
#         comb(k,i+1,idx+1,choosed)
#         choosed.remove(array[i])
        

# for i in range(2,S+1):
#     comb(i,0,0,[])
    
# print(visited.index(False))