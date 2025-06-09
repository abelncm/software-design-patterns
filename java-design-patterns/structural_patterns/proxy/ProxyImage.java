package structural_patterns.proxy;

/**
 * Proxy Class: Implements the Subject interface (Image) and holds a reference
 * to a RealSubject (RealImage) instance.
 * This is a Virtual Proxy that creates and loads the RealImage object on demand (lazy initialization).
 */
public class ProxyImage implements Image {
    private RealImage realImage; // Reference to the RealSubject
    private String fileName;
    private boolean loadAttempted = false;

    /**
     * Constructor for ProxyImage.
     * @param fileName The name of the image file to be potentially loaded.
     */
    public ProxyImage(String fileName) {
        this.fileName = fileName;
        System.out.println("ProxyImage: Created for " + fileName + ". RealImage not loaded yet.");
    }

    /**
     * Displays the image. If the RealImage is not yet created or loaded,
     * this method will instantiate and load it first.
     * This demonstrates lazy initialization.
     */
    @Override
    public void display() {
        System.out.println("ProxyImage: Call to display image '" + fileName + "'.");
        if (realImage == null) {
            System.out.println("ProxyImage: RealImage for '" + fileName + "' is null. Instantiating and loading...");
            realImage = new RealImage(fileName); // Lazy instantiation of RealImage
            // The RealImage's display method will handle the actual loading from disk if needed.
        } else if (!realImage.isImageLoaded() && !loadAttempted) {
            // This case might occur if RealImage was instantiated but loading was deferred
            // and then display is called again on proxy.
            // However, our RealImage loads on its first display() if not loaded.
            // This Proxy primarily focuses on lazy instantiation of RealImage.
            System.out.println("ProxyImage: RealImage for '" + fileName + "' exists but might not be loaded. Delegating to RealImage.display().");
        }

        // Delegate to the RealSubject's display method.
        // RealImage.display() will handle its internal loading logic.
        if (realImage != null) {
            realImage.display();
            loadAttempted = true; // Mark that we've tried to load/display via realImage
        } else {
            // Should not happen if instantiation logic is correct
            System.err.println("ProxyImage: Error - RealImage could not be instantiated for " + fileName);
        }
    }

    @Override
    public String getFileName() {
        // Can return filename without loading the real image
        return fileName;
    }

    // Optional: A method to check if the proxy has loaded the real image
    // This is for demonstration purposes.
    public boolean isRealImageLoaded() {
        return realImage != null && realImage.isImageLoaded();
    }
}
