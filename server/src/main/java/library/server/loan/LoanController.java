package library.server.loan;
import library.server.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> getLoans() {
        return loanService.getAllLoans();
    }

    @PostMapping
    public Loan addLoan(@RequestBody Loan loan) {
        return loanService.addLoan(
                loan.getBook().getId(),
                loan.getStartDate(),
                loan.getEndDate()
        );
    }

    @DeleteMapping("/{loanId}")
    public void endLoan(@PathVariable Long loanId) {
        loanService.endLoan(loanId);
    }
}