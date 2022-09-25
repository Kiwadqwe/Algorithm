def check(l,win):
    c = 0
    d = [6,6,5,4,3,2,1]
    
    for w in win:
        if w in l:
            c+=1
    
    return d[c+l.count(0)],d[c]

def solution(lottos, win_nums):
    if 6 == lottos.count(0):
        return 1,6
    
    return check(lottos,win_nums)

print(solution(	[44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]))
print(solution(	[0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]))
print(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]))
print(solution([45, 4, 35, 20, 3, 9], [100,101,102,103,104,105]))