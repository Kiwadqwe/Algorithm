import re

def solution(new_id):
    new_id = new_id.lower()
    id = re.sub(r"[^a-z0-9-_.]","",new_id)
    id = re.sub('\.+', '.', id)
    id = id.lstrip('.').rstrip('.')

    if not len(id):
        id = "a"
        
    if 16 <= len(id):
        id = id[:15].rstrip('.')
        
    if len(id) <= 2:
        id +=id[-1] * (3 - len(id))
        
    return id

print(solution("...!@BaT#*..y.abcdefghijklm"))
print(solution("z-+.^."))
print(solution("=.="))
print(solution("123_.def"))
print(solution("abcdefghijklmn.p"))