package Lab3IvaniukKI304;

import java.io.IOException;

/**
 * The {@code PondApp} class is a simple program that demonstrates the
 * usage of the {@link Pond} and {@link Sea} classes.
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
        // Creating and using the Sea class through a Pond reference
        Sea sea1 = new Sea(12, 10, 2, 35.0);
        sea1.setLength(1026);
        System.out.println("Length: " + sea1.getLength());
        sea1.setWidth(521);
        System.out.println("Width: " + sea1.getWidth());
        sea1.setDepth(3);
        System.out.println("Depth: " + sea1.getDepth());
        sea1.area();
        sea1.volume();
        sea1.perimeter();
        sea1.maxValue();
        sea1.calculateVolumeByPercentage(70);
        sea1.scale(3);
        sea1.determineDepth();
        sea1.swim();
        sea1.logSeaProperties();

        try {
            sea1.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
