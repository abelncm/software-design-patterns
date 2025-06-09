package behavioral_patterns.iterator;

/**
 * Client Class (Demo): Uses the Aggregate's factory method (createIterator)
 * to get an Iterator and then uses the iterator to traverse and access
 * the elements of the aggregate object without knowing its internal structure.
 */
public class IteratorDemo {
    public static void main(String[] args) {
        System.out.println("--- Iterator Pattern Demo: Book Collection ---");

        // Create a ConcreteAggregate instance
        BookCollection bookCollection = new BookCollection();

        // Add some Book objects to the collection
        bookCollection.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
        bookCollection.addBook(new Book("Pride and Prejudice", "Jane Austen"));
        bookCollection.addBook(new Book("1984", "George Orwell"));
        bookCollection.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        System.out.println("\nGetting iterator from BookCollection...");
        // Get an iterator from the aggregate
        CustomIterator<Book> iterator = bookCollection.createIterator();

        System.out.println("\nIterating through the Book Collection using the iterator:");
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Retrieved Book: " + book.getTitle() + " by " + book.getAuthor());
        }

        System.out.println("\nAttempting to call next() after iteration finished (should throw exception):");
        try {
            iterator.next(); // This should throw NoSuchElementException
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("\n--- Creating another iterator for the same collection (demonstrates multiple traversals) ---");
        CustomIterator<Book> iterator2 = bookCollection.createIterator();
        System.out.println("Second iterator: hasNext()? " + iterator2.hasNext());
        if(iterator2.hasNext()){
            System.out.println("Second iterator: next() -> " + iterator2.next().getTitle());
        }

        System.out.println("\n--- Iterating over an empty collection ---");
        BookCollection emptyCollection = new BookCollection();
        CustomIterator<Book> emptyIterator = emptyCollection.createIterator();
        System.out.println("Empty iterator: hasNext()? " + emptyIterator.hasNext());
        if (!emptyIterator.hasNext()) {
            System.out.println("As expected, empty iterator has no next element.");
        }
        try {
            emptyIterator.next();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught expected exception for empty iterator: " + e.getMessage());
        }


        System.out.println("\n--- Iterator Pattern Demo Finished ---");
    }
}
