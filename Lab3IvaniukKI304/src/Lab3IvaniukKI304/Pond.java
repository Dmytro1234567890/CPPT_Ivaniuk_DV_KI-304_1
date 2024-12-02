package Lab3IvaniukKI304;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The {@code Pond} class represents a pond with various attributes and behaviors.
 * It can log the pond's activities to a text file.
 * This class is abstract and should be extended by specific water bodies like Sea.
 *
 * @author Ivaniuk Dmytro
 */
public abstract class Pond {
    protected int length;
    protected int width;
    protected int depth;
    protected String logFileName;
    protected FileWriter logFileWriter;

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
     * @param width  The width of the pond.
     * @param depth  The depth of the pond.
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

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public void area() {
        log("Area: " + length * width + " km^2");
    }

    public void volume() {
        log("Volume: " + length * width * depth + " km^3");
    }

    public void perimeter() {
        log("Perimeter: " + 2 * (length + width) + " km");
    }

    public void maxValue() {
        log("Max value: " + Math.max(length, Math.max(width, depth)));
    }

    public void scale(int scaleFactor) {
        this.length *= scaleFactor;
        this.width *= scaleFactor;
        this.depth *= scaleFactor;
        log("Scales each parameter by " + scaleFactor);
    }

    public void calculateVolumeByPercentage(double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("The percentage must be between 0 and 100.");
        } else {
            log("Volume(" + percentage + "%): " + length * width * depth * (percentage / 100) + " km^3");
        }
    }

    public void determineDepth() {
        if (depth >= 1) {
            log("The pond is deep. Its depth is " + depth + " km.");
        } else {
            log("The pond is shallow. Its depth is " + depth + " km.");
        }
    }

    public void log(String message) {
        try {
            logFileWriter.write(message + "\n");
            logFileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dispose() throws IOException {
        logFileWriter.close();
    }

    // Abstract method that needs to be implemented by subclasses.
    public abstract void uniqueFeature();
}

