package Lab2IvaniukKI304;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * The {@code Pond} class represents a pond with various attributes and behaviors.
 * It can log the pond's activities to a text file.
 *
 * @author Ivaniuk Dmytro
 */
public class Pond {
    private int length;
    private int width;
    private int depth;
    private String logFileName;
    private FileWriter logFileWriter;
    /**
     * Constructs a new pond with default values and initializes a log file.
     */
    public Pond() {
        this.length = 0;
        this.width = 0;
        this.depth = 0;
        logFileName = "pondLog.txt";
        try {
            logFileWriter = new FileWriter(new File(logFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Constructs a new pond with the specified length, width, and depth, and initializes a log file.
     *
     * @param length The length of the pond.
     * @param width The width of the pond.
     * @param depth The depth of the pond.
     */
    public Pond(int length, int width, int depth) {
        this.length = length;
        this.width = width;
        this.depth = depth;
        logFileName = "pondLog.txt";
        try {
            logFileWriter = new FileWriter(new File(logFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Sets the length of the pond.
     *
     * @param length The length of the pond.
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     * Sets the width of the pond.
     *
     * @param width The width of the pond.
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * Sets the depth of the pond.
     *
     * @param depth The depth of the pond.
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
    /**
     * Gets the length of the pond.
     *
     * @return The length of the pond.
     */
    public int getLength() {
        return length;
    }
    /**
     * Gets the width of the pond.
     *
     * @return The width of the pond.
     */
    public int getWidth() {
        return width;
    }
    /**
     * Gets the depth of the pond.
     *
     * @return The depth of the pond.
     */
    public int getDepth() {
        return depth;
    }
    /**
     * Calculates the area and logs the action.
     */
    public void area() {
        log("Area: " + length*width + " m^2");
    }
    /**
     * Calculates the volume and logs the action.
     */
    public void volume() {
        log("Volume: " + length*width*depth + " m^3");
    }
    /**
     * Calculates the perimeter and logs the action.
     */
    public void perimeter() {
        log("Perimeter: " + 2*(length+width) + " m");
    }
    /**
     * Finds the maximum value and logs the action.
     */
    public void maxValue() {
        log("Max value: " + Math.max(length, Math.max(width, depth)));
    }
    /**
     * Scales dimensions and logs the action.
     */
    public void scale(int scaleFactor) {
        this.length *= scaleFactor;
        this.width *= scaleFactor;
        this.depth *= scaleFactor;
        log("Scales each parameter by " + scaleFactor);
    }
    /**
     * Calculates the volume by percentage and logs the action.
     */
    public void calculateVolumeByPercentage(double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("The percentage must be between 0 and 100.");
        }else {
            log("Volume(" + percentage + "%): " +length*width*depth*(percentage/100) + " m^3");
        }
    }
    /**
     * Determine the depth of the pond and logs the action.
     */
    public void determineDepth() {
        if (depth >= 5) {
            log("The pond is deep. Its depth is " + depth + " meters.");
        } else {
            log("The pond is shallow. Its depth is " + depth + " meters.");
        }
    }
    /**
     * Logs a message to the log file.
     *
     * @param message The message to log.
     */
    public void log(String message) {
        try {
            logFileWriter.write(message + "\n");
            logFileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Closes the cat's log file.
     *
     * @throws IOException If an I/O error occurs while closing the log file.
     */
    public void dispose() throws IOException {
        logFileWriter.close();
    }
}
