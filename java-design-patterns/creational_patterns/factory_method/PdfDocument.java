package creational_patterns.factory_method;

/**
 * ConcreteProduct: Implements the Document interface for PDF documents.
 */
public class PdfDocument implements Document {
    private String name;

    public PdfDocument(String name) {
        this.name = name;
        System.out.println("PdfDocument '" + name + "' created.");
    }

    @Override
    public void open() {
        System.out.println("Opening PDF document: " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document: " + name);
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document: " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
