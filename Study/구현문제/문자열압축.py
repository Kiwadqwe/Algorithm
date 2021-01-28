n =input()
leng=len(n)
cnt=0
cnt1=0
cnt2=0

for i in range(1,leng):
    # save=n[0:i]
    for j in range(i,leng):
        if n[0:1]==n[1:2]:
            cnt+=1
            if n[0:2]==n[2:4]:
                cnt1+=1
                if n[0:3]==n[3:6]:
                    cnt2+=1


            