package creational_patterns.factory_method;

/**
 * Creator abstract class: Declares the factory method (createDocument)
 * which returns an object of type Document (Product).
 * It can also define methods that use the factory method.
 */
public abstract class DocumentCreator {

    // The factory method, to be implemented by subclasses.
    public abstract Document createDocument(String name);

    // A method that uses the factory method.
    // This is an example of how the Creator might use the Product it creates.
    public void newDocument(String name) {
        Document doc = createDocument(name); // Calls the factory method
        System.out.println("DocumentCreator: Processing new document '" + doc.getName() + "'");
        doc.open();
        // ... potentially more operations with the document
    }

    public void openDocument(String name) {
        Document doc = createDocument(name);
        System.out.println("DocumentCreator: Re-opening document '" + doc.getName() + "'");
        doc.open();
    }
}
