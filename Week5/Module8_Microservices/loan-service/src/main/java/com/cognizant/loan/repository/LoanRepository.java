// repository for loan - gives me free CRUD methods
package com.cognizant.loan.repository;

import com.cognizant.loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    // find loan by loan number
    Optional<Loan> findByLoanNumber(String loanNumber);

    // find all loans by customer name
    List<Loan> findByCustomerName(String customerName);

    // find loans by type like HOME or CAR
    List<Loan> findByLoanType(String loanType);

    // find loans by status like ACTIVE or CLOSED
    List<Loan> findByStatus(String status);

    // find all loans linked to an account number
    // this is how I connect loan service with account service
    List<Loan> findByAccountNumber(String accountNumber);
}
