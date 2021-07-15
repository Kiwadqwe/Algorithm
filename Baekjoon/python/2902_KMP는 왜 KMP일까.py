import sys
input = sys.stdin.readline

ipu = input()
result=""

for i in range(len(ipu)):
    if 64<ord(ipu[i])<95:
        result+=ipu[i]

print(result)