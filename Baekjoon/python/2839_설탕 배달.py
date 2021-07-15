n = int(input());
b=0;
while True:
    if n%5==0:
        b=b+(n//5);
        print(b);  
        break;
    elif n==1 or n==2:
        print("-1");
        break;
    n=n-3
    b+=1;

