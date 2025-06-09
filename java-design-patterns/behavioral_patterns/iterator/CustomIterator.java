package behavioral_patterns.iterator;

/**
 * Iterator Interface (Custom): Declares methods for traversing elements of a collection.
 * This is a custom interface for pedagogical purposes.
 * Java's built-in java.util.Iterator is typically used.
 *
 * @param <T> The type of elements this iterator will traverse.
 */
public interface CustomIterator<T> {
    /**
     * Checks if there are more elements to iterate over.
     * @return true if there are more elements, false otherwise.
     */
    boolean hasNext();

    /**
     * Retrieves the next element in the iteration.
     * @return The next element.
     */
    T next();

    // Optional: remove() method
    // default void remove() {
    //     throw new UnsupportedOperationException("remove");
    // }
}
