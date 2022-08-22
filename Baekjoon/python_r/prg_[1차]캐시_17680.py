def solution(cacheSize, cities):
    answer = 0
    
    cache = []
    for c in cities:
        c = c.lower()
        if not c in cache:
            if len(cache) < cacheSize:
                cache.append(c)
            elif cache:
                cache.pop(0)
                cache.append(c)
            answer+=5           
        else:
            cache.pop(cache.index(c))
            cache.append(c)
            answer+=1
            
    return answer

# print(solution(3,["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))
print(solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"]))