// this is my Account class
// it stores bank account details in database
// @Entity means this class will become a table in database
package com.cognizant.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

    // @Id means this is the primary key
    // @GeneratedValue means database will auto generate the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // account number like ACC001
    private String accountNumber;

    // name of account holder
    private String accountHolderName;

    // type of account - SAVINGS or CURRENT
    private String accountType;

    // money in account
    private Double balance;

    // is account active or not
    private String status;

    // empty constructor needed by JPA
    public Account() {
    }

    // constructor to create account with all details except id
    public Account(String accountNumber, String accountHolderName,
                   String accountType, Double balance, String status) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
    }

    // getters and setters - needed to access private fields
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // toString to print account details
    @Override
    public String toString() {
        return "Account [id=" + id + ", accountNumber=" + accountNumber +
               ", accountHolderName=" + accountHolderName +
               ", accountType=" + accountType +
               ", balance=" + balance +
               ", status=" + status + "]";
    }
}
