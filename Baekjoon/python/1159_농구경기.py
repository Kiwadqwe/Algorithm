import sys

n = int(input())
array=[]

for i in range(n):
    m = input()
    array.append(m[0])
    
array.sort()

li=[0]*26
cnt=0
for i in array:
    for j in range(26):
        if ord(i)-97==j:
            li[j]+=1
            break
k=" "
for i in range(len(li)):
    if li[i]>=5:
        k=chr(i+97)
        print(k,end="")
if k==" ":
    print("PREDAJA")