import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "Effective Java", "Joshua Bloch"));
        books.add(new Book("2", "Clean Code", "Robert C. Martin"));
        books.add(new Book("3", "Design Patterns", "Gamma, Helm, Johnson, Vlissides"));

        // Linear Search
        Book foundBookLinear = linearSearchByTitle(books, "Clean Code");
        if (foundBookLinear != null) {
            System.out.println("Linear Search Found: " + foundBookLinear);
        } else {
            System.out.println("Book not found with Linear Search.");
        }

        // Binary Search (sorted by title)
        books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));  // Ensure books are sorted
        Book foundBookBinary = binarySearchByTitle(books, "Clean Code");
        if (foundBookBinary != null) {
            System.out.println("Binary Search Found: " + foundBookBinary);
        } else {
            System.out.println("Book not found with Binary Search.");
        }
    }

    public static Book linearSearchByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}
