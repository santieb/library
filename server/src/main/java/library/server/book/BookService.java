package library.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public void createBook(Book book) {
        if (isValidBook(book)) {
            this.bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Invalid book details");
        }
    }

    private boolean isValidBook(Book book) {
        return book != null && book.getTitle() != null && !book.getTitle().isEmpty()
                && book.getAuthor() != null && !book.getAuthor().isEmpty();
    }

    public void updateBook(Long bookId, Book updatedBook) {
        Book existingBook = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        if (isValidBook(updatedBook)) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGender(updatedBook.getGender());
            existingBook.setNum_pages(updatedBook.getNum_pages());
            existingBook.setSinopsis(updatedBook.getSinopsis());

            this.bookRepository.save(existingBook);
        } else {
            throw new IllegalArgumentException("Invalid book details");
        }
    }

    public void deleteBook(Long bookId) {
        Book existingBook = this.bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        this.bookRepository.delete(existingBook);
    }
}
