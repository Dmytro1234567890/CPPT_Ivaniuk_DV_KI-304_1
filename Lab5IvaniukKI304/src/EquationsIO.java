import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;

public class EquationsIO {
    public void writeToTextFile(String fileName, double result) throws IOException {
        try (PrintWriter fout = new PrintWriter(new File(fileName))) {
            fout.printf("%.16f", result);
        }
    }

    public double readFromTextFile(String fileName) throws IOException {
        try (Scanner fin = new Scanner(new File(fileName))) {
            if (fin.hasNextDouble()) {
                return fin.nextDouble();
            } else {
                throw new IOException("Invalid content in text file.");
            }
        }
    }

    public void writeToBinaryFile(String fileName, double result) throws IOException {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(fileName))) {
            dout.writeDouble(result);
        }
    }

    public double readFromBinaryFile(String fileName) throws IOException {
        try (DataInputStream din = new DataInputStream(new FileInputStream(fileName))) {
            return din.readDouble();
        }
    }
}