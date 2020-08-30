n, m = map(int,input().split())

array = list(map(int,input().split()))

start=0
end= max(array)
cut=0

while(start<=end):
    hap=0
    mid=(start+end)//2
    for i in array:
        # array데이터가 i보다 작으면 빼줌,어짜피 음수가 되면 0이 되기 때문
        if i>mid:
            hap+=i-mid
    # hap보다 작으면 end를 1씩 줄여줌
    if hap<m:
        end-=1
    # m을 맞추기보단 절단기의 최댓값을 출력하기 위하여 start=mid+1 해줌 
    else:
        cut=mid
        start=mid+1
print(cut)

# n, m = map(int,input().split())

# array = list(map(int,input().split()))

# start=0
# end= max(array)
# cut=0

# while True:
#     if start>=end:
#         break
#     hap=0
#     mid=(start+end)//2
#     for i in array:
#         if i>mid:
#             hap+=i-mid
#     if hap>m:
#         start=mid+1
#     elif hap==m:
#         cut=mid
#         break
#     else:
#         end-=1
# print(cut)