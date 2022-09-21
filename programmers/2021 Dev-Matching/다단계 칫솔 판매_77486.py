import math

def solution(enroll, referral, seller, amount):
    d = {x: 0 for x in enroll}
    l = len(seller)

    edges = dict(zip(enroll, referral))
    
    for i in range(l):
        price = amount[i] * 100
        person = seller[i]
        
        while True:
            d[person] += math.ceil(price * 0.9)
            if edges[person] == '-': break
            price //= 10 
            person = edges[person]
            if price == 0 : break
            
    return list(d.values())

print(solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"], ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"], ["young", "john", "tod", "emily", "mary"], [12, 4, 2, 5, 10]))
print(solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"], ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"], ["sam", "emily", "jaimie", "edward"], [2, 3, 5, 4]))