package behavioral_patterns.iterator;

/**
 * A simple class representing a Book with a title and author.
 * This is the type of object that will be stored in our aggregate collection.
 */
public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}
