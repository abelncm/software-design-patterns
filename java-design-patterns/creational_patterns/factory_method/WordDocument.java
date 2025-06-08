package creational_patterns.factory_method;

/**
 * ConcreteProduct: Implements the Document interface for Word documents.
 */
public class WordDocument implements Document {
    private String name;

    public WordDocument(String name) {
        this.name = name;
        System.out.println("WordDocument '" + name + "' created.");
    }

    @Override
    public void open() {
        System.out.println("Opening Word document: " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing Word document: " + name);
    }

    @Override
    public void save() {
        System.out.println("Saving Word document: " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
