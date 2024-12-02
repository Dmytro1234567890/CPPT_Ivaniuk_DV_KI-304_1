package Lab3IvaniukKI304;

/**
 * Interface that provides the capability of swimming.
 *
 * @author Ivaniuk Dmytro
 */
interface Swimmer {
    void swim();
}

/**
 * The {@code Sea} class represents a sea with additional attributes and behaviors.
 * It extends the {@link Pond} class and implements the {@link Swimmer} interface.
 */
public class Sea extends Pond implements Swimmer {
    private double salinity; // Additional attribute for salinity in ppt (parts per thousand).

    /**
     * Constructs a new sea with specified parameters and salinity.
     *
     * @param length   The length of the sea.
     * @param width    The width of the sea.
     * @param depth    The depth of the sea.
     * @param salinity The salinity of the sea.
     */
    public Sea(int length, int width, int depth, double salinity) {
        super(length, width, depth);
        this.salinity = salinity;
    }

    /**
     * Gets the salinity of the sea.
     *
     * @return The salinity of the sea.
     */
    public double getSalinity() {
        return salinity;
    }

    /**
     * Sets the salinity of the sea.
     *
     * @param salinity The salinity to set.
     */
    public void setSalinity(double salinity) {
        this.salinity = salinity;
    }

    /**
     * Provides the swimming behavior for the sea.
     */
    @Override
    public void swim() {
        log("Swimming in the sea with salinity: " + salinity + " ‰.");
    }

    /**
     * Provides a unique feature specific to the sea.
     */
    @Override
    public void uniqueFeature() {
        log("The sea has a unique feature: tidal waves.");
    }

    /**
     * Logs the sea's properties.
     */
    public void logSeaProperties() {
        log("Sea Properties: Length = " + getLength() + " km, Width = " + getWidth() + " km, Depth = " + getDepth() + " km, Salinity = " + salinity + " ‰.");
    }
}
