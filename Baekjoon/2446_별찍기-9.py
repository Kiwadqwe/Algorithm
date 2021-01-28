num = int(input());
for i in range(1,num+1):
    print(" "*(i-1)+"*"*(2*(num-i)+1));
for j in range(2,num+1):   
    print(" "*(num-j)+"*"*(2*j-1));