# def solution(s):
#     answer = ''
    
#     alpha = {"zero": 0, "one" : 1, "two" : 2 ,"three": 3,"four": 4,"five": 5, "six":6 ,"seven": 7,"eight": 8,"nine":9}
    
#     temp = ''
#     for a in s:
#         if a.isnumeric():
#             answer+=a
#         else:
#             temp+=a
#             if temp in alpha.keys():
#                 answer += str(alpha[temp])
#                 temp = ''
                
#     return int(answer)

def solution(s):
    answer = s
    
    alpha = {"zero": 0, "one" : 1, "two" : 2 ,"three": 3,"four": 4,"five": 5, "six":6 ,"seven": 7,"eight": 8,"nine":9}
    
    for x,y in alpha.items():
        answer = answer.replace(x,str(y))
        
        if answer.isnumeric(): return int(answer)
    
    
print(solution("oneoneonetwoone"))
print(solution("one4seveneight"))
print(solution("23four5six7"))
print(solution("2three45sixseven"))
print(solution("123"))
print(solution("100seve"))