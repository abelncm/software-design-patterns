package structural_patterns.proxy;

/**
 * Client Class (Demo): Interacts with the Subject (Image) via its interface,
 * unaware if it's using a RealSubject or a Proxy.
 */
public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("--- Proxy Pattern Demo: Virtual Proxy for Images ---");

        // Create ProxyImage instances. RealImage objects are not created at this point.
        System.out.println("\nStep 1: Creating proxy image objects.");
        Image image1 = new ProxyImage("photo_high_res_001.jpg");
        Image image2 = new ProxyImage("photo_high_res_002.png");
        Image image3 = new ProxyImage("photo_high_res_001.jpg"); // Another proxy for the same file

        System.out.println("\nStep 2: Displaying image1 for the first time.");
        // The RealImage for image1 will be created and loaded from disk now (on demand).
        image1.display();
        System.out.println("Status after first display of image1: Proxy has loaded RealImage -> " + ((ProxyImage)image1).isRealImageLoaded());


        System.out.println("\nStep 3: Displaying image1 again.");
        // The RealImage for image1 is already loaded, so it should just be displayed.
        image1.display();

        System.out.println("\nStep 4: Displaying image2 for the first time.");
        // The RealImage for image2 will be created and loaded now.
        image2.display();
        System.out.println("Status after first display of image2: Proxy has loaded RealImage -> " + ((ProxyImage)image2).isRealImageLoaded());

        System.out.println("\nStep 5: Displaying image3 (proxy for same file as image1).");
        // Even though image1 (same file) was loaded, image3 is a *different proxy instance*.
        // This proxy (image3) will create its own RealImage instance and load it.
        // A more advanced proxy/factory could share RealImage instances based on filename if desired,
        // but this example demonstrates a simple virtual proxy.
        image3.display();
        System.out.println("Status after first display of image3: Proxy has loaded RealImage -> " + ((ProxyImage)image3).isRealImageLoaded());

        System.out.println("\nStep 6: Checking file names (does not trigger load).");
        System.out.println("File name for image1: " + image1.getFileName());
        System.out.println("File name for image2: " + image2.getFileName());

        System.out.println("\n--- Proxy Pattern Demo Finished ---");
    }
}
