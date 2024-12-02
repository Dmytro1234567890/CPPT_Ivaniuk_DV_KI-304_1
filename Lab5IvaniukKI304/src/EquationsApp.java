import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;

/**
 * Class <code>EquationsApp</code> Implements driver for Equations class
 * that calculates the expression y = sin(x) / tg(4x)
 * and handles exceptions.
 * @author Dmytro Ivaniuk
 */
public class EquationsApp {
    /**
     * @param args
     */
    public static void main(String[] args) {
        EquationsIO io = new EquationsIO();
        Equations eq = new Equations();
        Scanner in = new Scanner(System.in);

        try {
            out.print("Enter text file name: ");
            String textFileName = in.nextLine();

            out.print("Enter binary file name: ");
            String binaryFileName = in.nextLine();

            out.print("Enter X: ");
            int x = in.nextInt();

            double result = eq.calculate(x);
            out.println("Calculated result: " + result);

          io.writeToTextFile(textFileName, result);
           out.println("Result written to text file: " + textFileName);

          io.writeToBinaryFile(binaryFileName, result);
          out.println("Result written to binary file: " + binaryFileName);

            double textResult = io.readFromTextFile(textFileName);
            out.println("Read from text file: " + textResult);

            double binaryResult = io.readFromBinaryFile(binaryFileName);
            out.println("Read from binary file: " + binaryResult);

        } catch (IOException | CalcException e) {
            out.println("Error: " + e.getMessage());
        }
    }

}



/**
 * Class <code>CalcException</code> more precisely defines ArithmeticException
 * for custom expression calculation errors.
 */
class CalcException extends ArithmeticException {
    public CalcException() {}
    public CalcException(String cause) {
        super(cause);
    }
}

/**
 * Class <code>Equations</code> implements method for calculating the
 * expression y = sin(x) / tg(4x).
 */
class Equations {
    /**
     * Method calculates the expression y = sin(x) / tg(4x)
     * @param x Angle in degrees
     * @throws CalcException if invalid input is provided
     */
    public double calculate(int x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0;

        // Check if 4x is a multiple of 180 (tan(4x) = 0)
        if (x % 45 == 0) {
            throw new CalcException("Exception reason: Division by zero (tan(4x) = 0 for x = " + x + " degrees)");
        }

        if ((4 * x - 90) % 180 == 0) {
            throw new CalcException("Exception reason: Undefined value of tan(4x) for x = " + x + " degrees");
        }

        try {
            // y = sin(x) / tan(4x)
            y = Math.sin(rad) / Math.tan(4 * rad);

            if (Double.isNaN(y) || Double.isInfinite(y)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            throw new CalcException("Unknown reason of the exception during expression calculation");
        }
        return y;
    }
}
