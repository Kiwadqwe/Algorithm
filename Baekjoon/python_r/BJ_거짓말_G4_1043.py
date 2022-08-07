# import sys
# input = sys.stdin.readline

# N,M = map(int,input().split())
# G = list(map(int,input().split()))[1:]
# d = dict()
# p = {x : [] for x in range(1,N+1)}

# for i in range(1,M+1):
#     s = list(map(int,input().split()))[1:]
#     d[i] = s
#     for ss in s:
#         t = p.get(ss)
#         t.append(i)
#         p[ss] = t

# if not len(G):
#     print(M)
#     sys.exit(0)
# else:
#     visited =  [True]+[False] * M
#     for g in G:
        
#         a = p.get(g)
#         for aa in a:
#             if not visited[aa]:
#                 s = d.get(aa)
#                 for ss in s:
#                     if ss not in G:
#                         G.append(ss)
                    
#             visited[aa] = True
#     cnt = 0
#     for v in visited:
#         if not v:
#             cnt+=1
            
#     print(cnt)

import sys

cnt_party = int(sys.stdin.readline().rstrip().split()[1])
witness_set = set(sys.stdin.readline().rstrip().split()[1:])

party_list = []
possible_list = []

for _ in range(cnt_party):
    party_list.append(set(sys.stdin.readline().rstrip().split()[1:]))
    possible_list.append(1)

for _ in range(cnt_party):
    for i, party in enumerate(party_list):
        if witness_set.intersection(party):
            possible_list[i] = 0
            witness_set = witness_set.union(party)

print(sum(possible_list))