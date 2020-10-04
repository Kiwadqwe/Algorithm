# def solution(participant, completion):
#     participant.sort()
#     completion.sort()
#     for par,com in zip(participant,completion):
#         if par !=com:
#             return par
#     # 다 아닐경우 리스트 인덱스가 큰 맨 뒤에 값을 출력
#     return participant[-1]

# participant = input().split()
# completion = input().split()
# print(solution(participant,completion))


import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]

participant = input().split()
completion = input().split()   

print(solution(participant,completion))
