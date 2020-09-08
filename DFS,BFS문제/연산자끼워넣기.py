n = int(input())
array= list(map(int,input().split()))
add, sub, mul, div = map(int,input().split())
# max,min 최댓값 최솟값 지정
max_result=-1e9
min_result=1e9

def dfs(i,val):
    global add,sub,mul,div,n,max_result,min_result
    # array리스트를 다 돌았을 때
    if i==n:
        max_result=max(max_result,val)
        min_result=min(min_result,val)
    else:
        if add>0:
            add-=1
            dfs(i+1,val+array[i])
            add+=1
        if sub>0:
            sub-=1
            dfs(i+1,val-array[i])
            sub+=1
        if mul>0:
            mul-=1
            dfs(i+1,val*array[i])
            mul+=1
        if div>0:
            div-=1
            dfs(i+1,int(val/array[i]))
            div+=1

dfs(1,array[0])
print(max_result)
print(min_result)
