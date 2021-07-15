a,b,c = list(map(int, input().split()));
if  b>=c:
    print(-1);
else:
    print(int(a/(c-b)+1))