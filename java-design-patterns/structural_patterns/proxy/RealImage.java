package structural_patterns.proxy;

/**
 * RealSubject Class: The actual object that the proxy represents.
 * It contains the core logic and is often resource-intensive to create or use.
 * In this example, RealImage loads an image from a (simulated) disk.
 */
public class RealImage implements Image {
    private String fileName;
    private boolean isLoaded = false; // To track if the image has been loaded

    /**
     * Constructor for RealImage.
     * @param fileName The name of the image file.
     */
    public RealImage(String fileName) {
        this.fileName = fileName;
        // The actual loading from disk is deferred to the loadFromDisk method,
        // which will be called by display() if not already loaded, or by the proxy.
        System.out.println("RealImage: Constructor called for " + fileName + ". (Image not loaded from disk yet)");
    }

    /**
     * Simulates loading the image from disk. This is considered an expensive operation.
     */
    private void loadFromDisk() {
        if (!isLoaded) {
            System.out.println("RealImage: Loading image '" + fileName + "' from disk...");
            // Simulate a delay for loading
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("RealImage: Loading interrupted for " + fileName);
            }
            isLoaded = true;
            System.out.println("RealImage: Image '" + fileName + "' loaded successfully.");
        } else {
            System.out.println("RealImage: Image '" + fileName + "' was already loaded.");
        }
    }

    /**
     * Displays the image. If the image is not already loaded,
     * it will first load it from disk.
     */
    @Override
    public void display() {
        if (!isLoaded) {
            loadFromDisk(); // Ensure image is loaded before displaying
        }
        if (isLoaded) {
            System.out.println("RealImage: Displaying image '" + fileName + "'.");
        } else {
            System.out.println("RealImage: Cannot display image '" + fileName + "' as it failed to load.");
        }
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    public boolean isImageLoaded() {
        return isLoaded;
    }
}
