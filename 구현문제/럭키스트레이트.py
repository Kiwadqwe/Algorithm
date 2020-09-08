n = input()
leng=len(n)

hap=0
hap1=0
temp=int(n)
for i in range(leng,0,-1):
    if i<=leng//2:
        hap1+=temp//pow(10,i-1)
    else:
        hap+=temp//pow(10,i-1)
    temp=temp%pow(10,i-1)   

if hap==hap1:
    print("LUCKY")
else:
    print("READY")