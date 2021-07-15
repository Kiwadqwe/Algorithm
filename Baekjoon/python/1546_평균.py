A = int(input())
B = list(map(int, input().split()));
C=[];
max_score=max(B);
for i in range(len(B)):
    C.append(B[i]/max_score*100);
avg=sum(C)/A    
print(avg) 