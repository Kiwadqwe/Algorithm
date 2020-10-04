import sys

input = sys.stdin.readline
ipu = input()

result=0

for i in range(len(ipu)):
    if 64<ord(ipu[i])<=67:
        result+=3
    elif 67<ord(ipu[i])<=70:
        result+=4
    elif 70<ord(ipu[i])<=73:
        result+=5
    elif 73<ord(ipu[i])<=76:
        result+=6
    elif 76<ord(ipu[i])<=79:
        result+=7
    elif 79<ord(ipu[i])<=83:
        result+=8
    elif 83<ord(ipu[i])<=86:
        result+=9
    elif 86<ord(ipu[i])<=90:
        result+=10
print(result)