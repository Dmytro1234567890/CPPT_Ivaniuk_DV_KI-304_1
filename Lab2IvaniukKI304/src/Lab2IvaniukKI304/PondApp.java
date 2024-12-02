package Lab2IvaniukKI304;
import java.io.IOException;
/**
 * The {@code PondApp} class is a simple program that demonstrates the
 usage
 * of the {@link Pond} class to create and interact with a Pond object.
 *
 * @author Ivaniuk Dmytro
 */
public class PondApp {
    /**
     * The main entry point of the program.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Pond pond1 = new Pond(12, 10, 2);
        pond1.setLength(16);
        System.out.println("Length: " + pond1.getLength());
        pond1.setWidth(13);
        System.out.println("Width: " + pond1.getWidth());
        pond1.setDepth(6);
        System.out.println("Depth: " + pond1.getDepth());
        pond1.area();
        pond1.volume();
        pond1.perimeter();
        pond1.maxValue();
        pond1.scale(3);
        pond1.calculateVolumeByPercentage(70);
        pond1.determineDepth();
        try {
            pond1.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
