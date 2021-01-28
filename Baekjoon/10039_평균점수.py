# def average(list):
#     sum=0;
#     for i in range(len(list)):
#         sum+=list[i];
#     return sum/len(list)

# input_num =[int(input()) for _ in range(5)]
# for i in range(len(input_num)):
#     if input_num[i]<40:
#         input_num[i]=40;
# print(average(input_num));
# print(input_num)

hap=0;
for i in range(5):
    num= int(input());
    if num<40:
        num=40;
    hap+=num;
print(hap//5)