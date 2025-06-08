package creational_patterns.factory_method;

/**
 * ConcreteCreator: Overrides the factory method to return an instance
 * of a specific ConcreteProduct (PdfDocument).
 */
public class PdfDocumentCreator extends DocumentCreator {
    @Override
    public Document createDocument(String name) {
        return new PdfDocument(name);
    }
}
