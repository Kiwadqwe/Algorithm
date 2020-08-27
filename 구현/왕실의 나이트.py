ipu = input()
col = int(ord(ipu[0]))
row = int(ipu[1])
load = [(-2,-1),(-2,1),(2,-1),(2,1),(1,2),(1,-2),(-1,2),(-1,-2)]

cnt=0

for i in load:
    temp_row = row + i[0]
    temp_col = col + i[1]   
     
    if temp_row >=1 or temp_row <=8 and temp_col >= 97 or temp_col <= 104:
        cnt+=1
print(cnt)