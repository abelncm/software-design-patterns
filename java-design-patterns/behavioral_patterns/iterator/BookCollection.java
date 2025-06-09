package behavioral_patterns.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * ConcreteAggregate Class: Implements the CustomIterable (Aggregate) interface.
 * It stores a collection of Book objects and implements the createIterator() method
 * to return an instance of its corresponding ConcreteIterator (BookIteratorImpl).
 */
public class BookCollection implements CustomIterable<Book> {
    private List<Book> books;

    public BookCollection() {
        this.books = new ArrayList<>();
        System.out.println("BookCollection: Initialized.");
    }

    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
            System.out.println("BookCollection: Added book - " + book.getTitle());
        }
    }

    public Book getBookAt(int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        return null;
    }

    public int getCount() {
        return books.size();
    }

    /**
     * Creates and returns an iterator for this BookCollection.
     * @return A CustomIterator<Book> instance.
     */
    @Override
    public CustomIterator<Book> createIterator() {
        System.out.println("BookCollection: Creating iterator.");
        return new BookIteratorImpl(this);
    }

    /**
     * ConcreteIterator Class (as an inner class): Implements the CustomIterator interface.
     * It keeps track of the current position in the traversal of this BookCollection.
     */
    private class BookIteratorImpl implements CustomIterator<Book> {
        private BookCollection collection;
        private int currentIndex = 0;

        /**
         * Constructor for BookIteratorImpl.
         * @param collection The BookCollection this iterator will traverse.
         */
        public BookIteratorImpl(BookCollection collection) {
            this.collection = collection;
            System.out.println("BookIteratorImpl: Initialized for BookCollection with " + collection.getCount() + " books.");
        }

        @Override
        public boolean hasNext() {
            boolean has = currentIndex < collection.getCount();
            // System.out.println("BookIteratorImpl: hasNext() called. Current index: " + currentIndex + ", Has next: " + has);
            return has;
        }

        @Override
        public Book next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more books in the collection.");
            }
            Book book = collection.getBookAt(currentIndex);
            // System.out.println("BookIteratorImpl: next() called. Returning book at index " + currentIndex + ": " + book.getTitle());
            currentIndex++;
            return book;
        }
    }
}
