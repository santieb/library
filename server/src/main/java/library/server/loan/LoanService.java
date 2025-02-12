package library.server.loan;
import java.time.LocalDate;
import library.server.loan.Loan;
import library.server.loan.LoanRepository;
import library.server.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library.server.book.Book;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookService bookService;

    @Autowired
    public LoanService(LoanRepository loanRepository, BookService bookService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
    }

    public Loan addLoan(Long bookId, LocalDate startDate, LocalDate endDate) {
        Book book = bookService.getBookById(bookId);

        if (book.getIsLoan()) {
            throw new IllegalStateException("Book is already on loan");
        }

        Loan loan = new Loan(startDate, endDate, book);
        loanRepository.save(loan);

        book.setIsLoan(true);
        bookService.updateBook(bookId, book);

        return loan;
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public void endLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        Book book = loan.getBook();
        book.setIsLoan(false);
        bookService.updateBook(book.getId(), book);

        loanRepository.delete(loan);
    }
}
