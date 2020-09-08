s=input()

hap=0
array=[]
for i in range(len(s)):
    if s[i].isalpha():
        array.append(s[i])
    else:
        hap+=int(s[i])
array.sort()
if hap!=0:
    array.append(str(hap))
#리스트 벗어나게 출력하고 싶을 때 join
print(''.join(array))