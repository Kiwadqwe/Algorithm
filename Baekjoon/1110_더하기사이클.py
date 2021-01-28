N =tmp = int(input());
count=0;
while True:
    mok=N//10;
    na= N%10;
    hap=mok+na;
    count+=1
    N=int(str(na)+str(hap%10));
    if N==tmp:
        break
print(count)