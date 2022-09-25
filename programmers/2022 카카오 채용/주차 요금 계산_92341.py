import math

def solution(fees, records):
    d,result = {},{}
    
    for r in records:
        a,b,c = r.split(" ")
        d[b] = [0,0,0]
        result[b] = 0
    
    for r in records:
        a,b,c = r.split(' ')
        x,y = a.split(":")
        a = int(x) * 60 + int(y)

        if c == "IN":
            if len(d[b]):
                d[b] = [d[b][0],a,c]
            else:    
                d[b] = [d[b][0],a,c]
        else:
            l = a - d[b][1]
            d[b] = [l+d[b][0],a,c]
            
    for x,y in d.items():
        if y[2] == "IN":
            l = 1439-y[1]
            d[x] = [y[0]+l,y[1],"OUT"]
    
    for x,y in d.items():
        if y[0] <= fees[0]:
            result[x] = fees[1]
        else:
            result[x] = fees[1] + math.ceil((y[0]-fees[0])/fees[2])*fees[3]
    
    return [x[1] for x in sorted(result.items())]


# print(solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
print(solution([120, 0, 60, 591], ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"]))