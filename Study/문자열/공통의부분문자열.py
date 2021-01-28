import sys

input =sys.stdin.readline

def set_str_array(s):
    return {s[i:j] for i in range(len(s)) for j in range(i, len(s)+1)}


in1 = str(input())
in2 = str(input())

result = max(set_str_array(in1) & set_str_array(in2))

print("\n%d\n'%s'" % (len(result), result))