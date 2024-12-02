import os
import struct
import sys
import math

def writeResTxt(fName, result):
    with open(fName, 'w') as f:
        f.write(str(result))

def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = float(f.read().strip())
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def writeResBin(fName, result):
    with open(fName, 'wb') as f:
        f.write(struct.pack('f', result))

def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def calculate(x):
    rad = math.radians(x)

    if x % 45 == 0:
        raise ValueError(f"Division by zero: tan(4x) = 0 for x = {x} degrees")

    if (4 * x - 90) % 180 == 0:
        raise ValueError(f"Undefined value: tan(4x) is not defined for x = {x} degrees")

    y = math.sin(rad) / math.tan(4 * rad)

    if math.isnan(y) or math.isinf(y):
        raise ValueError("The result is undefined (NaN or infinite)")

    return y


if __name__ == "__main__":
    data = float(input("Enter data: "))
    result = calculate(data)
    print(f"Result is: {result}")

    try:
        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)

        print(f"Result from text file: {readResTxt('textRes.txt')}")
        print(f"Result from binary file: {readResBin('binRes.bin')}")
    except FileNotFoundError as e:
        print(e)
        sys.exit(1)
