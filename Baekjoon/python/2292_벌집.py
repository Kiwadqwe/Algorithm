n = int(input());
room=1;
i=1;
num=1;
while True:
    if num<n:
        num=num+6*i;
        room+=1;
        i+=1;
    else:
        print(room);
        break;