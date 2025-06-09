package behavioral_patterns.iterator;

/**
 * Aggregate (or Iterable) Interface (Custom): Declares a factory method
 * for creating an iterator.
 * This is a custom interface for pedagogical purposes.
 * Java's built-in java.lang.Iterable is typically used.
 *
 * @param <T> The type of elements contained in the iterable.
 */
public interface CustomIterable<T> {
    /**
     * Creates an iterator for traversing the elements of this aggregate.
     * @return A CustomIterator for elements of type T.
     */
    CustomIterator<T> createIterator();
}
