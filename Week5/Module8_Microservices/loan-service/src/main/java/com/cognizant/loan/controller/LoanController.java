// REST controller for loan microservice
// handles all HTTP requests related to loans
package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import com.cognizant.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // GET /api/loans - get all loans
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        System.out.println("GET /api/loans");
        List<Loan> loans = loanService.getAllLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    // GET /api/loans/1 - get loan by id
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        System.out.println("GET /api/loans/" + id);
        try {
            Loan loan = loanService.getLoanById(id);
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET /api/loans/number/LOAN001
    @GetMapping("/number/{loanNumber}")
    public ResponseEntity<Loan> getLoanByNumber(@PathVariable String loanNumber) {
        System.out.println("GET /api/loans/number/" + loanNumber);
        try {
            Loan loan = loanService.getLoanByNumber(loanNumber);
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET /api/loans/account/ACC001 - get loans by account number
    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<List<Loan>> getLoansByAccount(@PathVariable String accountNumber) {
        System.out.println("GET /api/loans/account/" + accountNumber);
        List<Loan> loans = loanService.getLoansByAccountNumber(accountNumber);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    // GET /api/loans/type/HOME
    @GetMapping("/type/{loanType}")
    public ResponseEntity<List<Loan>> getLoansByType(@PathVariable String loanType) {
        System.out.println("GET /api/loans/type/" + loanType);
        List<Loan> loans = loanService.getLoansByType(loanType);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    // POST /api/loans - create new loan
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        System.out.println("POST /api/loans - creating loan for: " + loan.getCustomerName());
        Loan savedLoan = loanService.createLoan(loan);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

    // PUT /api/loans/1 - update loan
    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        System.out.println("PUT /api/loans/" + id);
        try {
            Loan updatedLoan = loanService.updateLoan(id, loan);
            return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /api/loans/1 - delete loan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        System.out.println("DELETE /api/loans/" + id);
        loanService.deleteLoan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
