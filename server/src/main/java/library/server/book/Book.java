package library.server.book;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import library.server.loan.Loan;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "library_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private int pages;
    private String synopsis;
    private boolean  isLoan = false;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Loan> loans = new ArrayList<>();

    public Book() {
    }

    public Book(Long id, String title, String author, String genre, int pages, String synopsis) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.synopsis = synopsis;
        this.isLoan = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
        loan.setBook(this);
        this.isLoan = true;
    }

    public void removeLoan(Loan loan) {
        this.loans.remove(loan);
        loan.setBook(null);
        this.isLoan = !this.loans.isEmpty();
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public boolean getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(boolean isLoan) {
        this.isLoan = isLoan;
    }
}
