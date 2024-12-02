 import java.io.*;
 import java.util.*;
 import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Клас Lab1IvaniukKI304 реалізує приклад програми до лабораторної роботи №1
 * @author Ivaniuk
 * @version 1.0
 * @since version 1.0
 *
 */

public class Lab1IvaniukKI304 {
    /**
     * Статичний метод main є точкою входу в програму
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(System.out, true, UTF_8);
        out.println("Введіть розмір квадратної матриці: ");
        Scanner in = new Scanner(System.in);
        int nRows = in.nextInt();
        out.println("Введіть символ-заповнювач: ");
        in.nextLine();
        String filler = in.nextLine();
        if (filler.length() != 1)
        {
            out.print("\nСимвол-заповнювач введено невірно.");
            System.exit(0);
        }

        char[][] arr = new char[nRows][nRows/2];

        for (int i = 0; i < nRows; i++) {
            if (i < nRows / 2) {
                for (int j = 0; j < nRows / 2; j++) {
                    arr[i][j] = (char)filler.codePointAt(0);
                    out.print(arr[i][j] + "\t");
                }
                for (int k = nRows / 2; k < nRows; k++) {
                    out.print(" \t");
                }
            } else {
                for (int k = 0; k < nRows / 2; k++) {
                    out.print(" \t");
                }
                for (int j = 0; j < nRows/2; j++) {
                        arr[i][j] = (char) filler.codePointAt(0);
                        out.print(arr[i][j] + "\t");
                }
            }
            out.println();
        }
        in.close();
        out.close();
    }
}

