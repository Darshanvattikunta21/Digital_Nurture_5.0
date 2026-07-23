// this is my Loan class
// it stores loan details in its own database
// loan service has SEPARATE database from account service
// this is the microservices principle - each service owns its data
package com.cognizant.loan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unique loan number
    private String loanNumber;

    // who took the loan
    private String customerName;

    // type of loan - HOME, CAR, PERSONAL, EDUCATION
    private String loanType;

    // total loan amount
    private Double loanAmount;

    // how much is still left to pay
    private Double remainingAmount;

    // interest rate per year
    private Double interestRate;

    // loan status - ACTIVE, CLOSED, PENDING
    private String status;

    // which account number this loan belongs to
    // this links loan to account but they are in different services
    private String accountNumber;

    // empty constructor for JPA
    public Loan() {
    }

    // constructor with all fields except id
    public Loan(String loanNumber, String customerName, String loanType,
                Double loanAmount, Double remainingAmount, Double interestRate,
                String status, String accountNumber) {
        this.loanNumber = loanNumber;
        this.customerName = customerName;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.remainingAmount = remainingAmount;
        this.interestRate = interestRate;
        this.status = status;
        this.accountNumber = accountNumber;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLoanNumber() { return loanNumber; }
    public void setLoanNumber(String loanNumber) { this.loanNumber = loanNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public Double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(Double loanAmount) { this.loanAmount = loanAmount; }

    public Double getRemainingAmount() { return remainingAmount; }
    public void setRemainingAmount(Double remainingAmount) { this.remainingAmount = remainingAmount; }

    public Double getInterestRate() { return interestRate; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    @Override
    public String toString() {
        return "Loan [id=" + id + ", loanNumber=" + loanNumber +
               ", customerName=" + customerName +
               ", loanType=" + loanType +
               ", loanAmount=" + loanAmount +
               ", remainingAmount=" + remainingAmount +
               ", status=" + status + "]";
    }
}
