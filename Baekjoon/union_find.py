p = [i for i in range(10)]

def union(x,y):
    a = get(x)
    b = get(y)
    
    if a != b:
        p[a] = b

def get(x):
    if x != p[x]:
        p[x] = get(p[x])
    
    return p[x]

def find(x,y):
    a = get(x)
    b = get(y)
    
    if a == b:
        return True

    return False

union(1,2)
union(2,3)
union(3,4)
union(5,7)
union(8,9)
print("1과 2는 연결되어있나요?",find(1,2))
print("2과 3는 연결되어있나요?",find(2,3))
print("3과 4는 연결되어있나요?",find(3,4))
print("5과 6는 연결되어있나요?",find(5,6))
print("8과 9는 연결되어있나요?",find(8,9))
print()