def solution(numbers, hand):
    answer = ''
    left,right = (3,0),(3,2)
    
    d = {1 : (0,0), 2 : (0,1), 3: (0,2), 4: (1,0),5:(1,1) ,6:(1,2),7:(2,0),8:(2,1),9:(2,2),0:(3,1)}
            
    for n in numbers:
        if (n == 1 or n == 4 or n == 7):
            left = d[n]
            answer+="L"
        elif (n == 3 or n == 6 or n == 9):
            right = d[n]
            answer+="R"
        else:
            x,y = d[n]
            
            a = (abs(x-left[0])+abs(y-left[1]))
            b = (abs(x-right[0])+abs(y-right[1]))
            if a < b:
                left = (x,y)
                answer+="L"
            elif b < a:
                right = (x,y)
                answer+="R"
            else:
                if hand == 'left':
                    left = (x,y)
                    answer+="L"
                else:
                    right = (x,y)
                    answer+="R"
            
    return answer
    
print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"))
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"))