s = input()
a=0
hap=int(s[0])
for i in range(1,len(s)):
    a=int(s[i])
    if a<=2:
        hap=hap+a
    else:
        hap=hap*a
print(hap)