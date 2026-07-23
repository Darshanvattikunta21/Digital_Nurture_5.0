// service class for loan microservice
package com.cognizant.loan.service;

import com.cognizant.loan.model.Loan;
import com.cognizant.loan.repository.LoanRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    // add sample loans when app starts
    @PostConstruct
    public void addSampleData() {
        System.out.println("Adding sample loan data...");

        Loan loan1 = new Loan("LOAN001", "Rahul Kumar", "HOME", 2000000.0, 1800000.0, 8.5, "ACTIVE", "ACC001");
        Loan loan2 = new Loan("LOAN002", "Priya Sharma", "CAR", 500000.0, 350000.0, 9.0, "ACTIVE", "ACC002");
        Loan loan3 = new Loan("LOAN003", "Sam Wilson", "PERSONAL", 100000.0, 50000.0, 12.0, "ACTIVE", "ACC003");
        Loan loan4 = new Loan("LOAN004", "Anita Singh", "EDUCATION", 800000.0, 800000.0, 7.5, "PENDING", "ACC004");
        Loan loan5 = new Loan("LOAN005", "Rahul Kumar", "CAR", 300000.0, 0.0, 9.0, "CLOSED", "ACC001");

        loanRepository.save(loan1);
        loanRepository.save(loan2);
        loanRepository.save(loan3);
        loanRepository.save(loan4);
        loanRepository.save(loan5);

        System.out.println("Sample loans added successfully!");
    }

    // get all loans
    public List<Loan> getAllLoans() {
        System.out.println("Getting all loans...");
        return loanRepository.findAll();
    }

    // get loan by id
    public Loan getLoanById(Long id) {
        System.out.println("Getting loan with id: " + id);
        Optional<Loan> loan = loanRepository.findById(id);
        if (loan.isPresent()) {
            return loan.get();
        } else {
            throw new RuntimeException("Loan not found with id: " + id);
        }
    }

    // get loan by loan number
    public Loan getLoanByNumber(String loanNumber) {
        System.out.println("Getting loan with number: " + loanNumber);
        Optional<Loan> loan = loanRepository.findByLoanNumber(loanNumber);
        if (loan.isPresent()) {
            return loan.get();
        } else {
            throw new RuntimeException("Loan not found with number: " + loanNumber);
        }
    }

    // get all loans for an account number
    // this shows how loan service connects to account data
    public List<Loan> getLoansByAccountNumber(String accountNumber) {
        System.out.println("Getting loans for account: " + accountNumber);
        return loanRepository.findByAccountNumber(accountNumber);
    }

    // get loans by type
    public List<Loan> getLoansByType(String loanType) {
        System.out.println("Getting loans of type: " + loanType);
        return loanRepository.findByLoanType(loanType);
    }

    // create new loan
    public Loan createLoan(Loan loan) {
        System.out.println("Creating new loan for: " + loan.getCustomerName());
        return loanRepository.save(loan);
    }

    // update loan details
    public Loan updateLoan(Long id, Loan updatedLoan) {
        System.out.println("Updating loan with id: " + id);
        Loan existingLoan = getLoanById(id);
        existingLoan.setCustomerName(updatedLoan.getCustomerName());
        existingLoan.setLoanType(updatedLoan.getLoanType());
        existingLoan.setLoanAmount(updatedLoan.getLoanAmount());
        existingLoan.setRemainingAmount(updatedLoan.getRemainingAmount());
        existingLoan.setInterestRate(updatedLoan.getInterestRate());
        existingLoan.setStatus(updatedLoan.getStatus());
        return loanRepository.save(existingLoan);
    }

    // delete loan
    public void deleteLoan(Long id) {
        System.out.println("Deleting loan with id: " + id);
        loanRepository.deleteById(id);
        System.out.println("Loan deleted!");
    }
}
