import sys
input = sys.stdin.readline

a = input().strip()
b = list(input().strip())
tp = []

for i in range(len(a)):
    tp.append(a[i])
    print(tp[-len(b):])
    if tp[-len(b):] == b:
        del tp[-len(b):]

if tp:
    print("".join(tp))
else:
    print("FRULA")

# mirkovC4nizCC44
# C4

# mirkovniz

# 12ab112ab2ab
# 12ab

# FRULA

# mirkovC4nizCC44
# C4

# mirkovniz

# 12ab112ab2ab
# 12ab

# FRULA