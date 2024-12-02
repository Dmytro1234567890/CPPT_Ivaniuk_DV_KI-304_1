import sys

def Lab7IvaniukKI304():
    try:
        rows = int(input("Введіть розмір квадратної матриці: "))
    except ValueError:
        print("Розмір матриці має бути числом")
        sys.exit(1)

    filler = input("Введіть символ-заповнювач: ")
    if len(filler) != 1:
        print("\nНеобхідно ввести один символ")
        sys.exit(1)

    arr = [[' ' for _ in range(rows // 2)] for _ in range(rows)]

    for i in range(rows):
        if i < rows // 2:
            for j in range(rows // 2):
                arr[i][j] = filler
                print(arr[i][j], end="\t")

            for k in range(rows // 2, rows):
                print(" ", end="\t")
        else:
            for k in range(rows // 2):
                print(" ", end="\t")

            for j in range(rows // 2):
                arr[i][j] = filler
                print(arr[i][j], end="\t")

        print()


if __name__ == "__main__":
    Lab7IvaniukKI304()
