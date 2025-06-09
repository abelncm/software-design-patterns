package structural_patterns.proxy;

/**
 * Subject Interface: Defines the common interface for both RealSubject (RealImage)
 * and Proxy (ProxyImage). This allows the client to treat them interchangeably.
 */
public interface Image {
    /**
     * Displays the image.
     */
    void display();

    /**
     * Gets the file name of the image.
     * @return The file name.
     */
    String getFileName();
}
