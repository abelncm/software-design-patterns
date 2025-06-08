package creational_patterns.factory_method;

/**
 * ConcreteCreator: Overrides the factory method to return an instance
 * of a specific ConcreteProduct (WordDocument).
 */
public class WordDocumentCreator extends DocumentCreator {
    @Override
    public Document createDocument(String name) {
        return new WordDocument(name);
    }
}
