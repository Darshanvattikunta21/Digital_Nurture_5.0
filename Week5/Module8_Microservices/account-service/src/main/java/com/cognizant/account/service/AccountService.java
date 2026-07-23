// service class contains the business logic
// it talks to the repository to get data from database
package com.cognizant.account.service;

import com.cognizant.account.model.Account;
import com.cognizant.account.repository.AccountRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    // inject the repository
    @Autowired
    private AccountRepository accountRepository;

    // this method runs when the application starts
    // it adds some test data to the database
    @PostConstruct
    public void addSampleData() {
        System.out.println("Adding sample account data...");

        Account acc1 = new Account("ACC001", "Rahul Kumar", "SAVINGS", 50000.0, "ACTIVE");
        Account acc2 = new Account("ACC002", "Priya Sharma", "CURRENT", 150000.0, "ACTIVE");
        Account acc3 = new Account("ACC003", "Sam Wilson", "SAVINGS", 25000.0, "ACTIVE");
        Account acc4 = new Account("ACC004", "Anita Singh", "CURRENT", 200000.0, "ACTIVE");
        Account acc5 = new Account("ACC005", "Dev Patel", "SAVINGS", 75000.0, "INACTIVE");

        accountRepository.save(acc1);
        accountRepository.save(acc2);
        accountRepository.save(acc3);
        accountRepository.save(acc4);
        accountRepository.save(acc5);

        System.out.println("Sample accounts added successfully!");
    }

    // get all accounts from database
    public List<Account> getAllAccounts() {
        System.out.println("Getting all accounts from database...");
        return accountRepository.findAll();
    }

    // get one account by id
    public Account getAccountById(Long id) {
        System.out.println("Getting account with id: " + id);
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new RuntimeException("Account not found with id: " + id);
        }
    }

    // get account by account number
    public Account getAccountByNumber(String accountNumber) {
        System.out.println("Getting account with number: " + accountNumber);
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new RuntimeException("Account not found with number: " + accountNumber);
        }
    }

    // save new account to database
    public Account createAccount(Account account) {
        System.out.println("Creating new account for: " + account.getAccountHolderName());
        return accountRepository.save(account);
    }

    // update existing account
    public Account updateAccount(Long id, Account updatedAccount) {
        System.out.println("Updating account with id: " + id);
        Account existingAccount = getAccountById(id);
        existingAccount.setAccountHolderName(updatedAccount.getAccountHolderName());
        existingAccount.setAccountType(updatedAccount.getAccountType());
        existingAccount.setBalance(updatedAccount.getBalance());
        existingAccount.setStatus(updatedAccount.getStatus());
        return accountRepository.save(existingAccount);
    }

    // delete account from database
    public void deleteAccount(Long id) {
        System.out.println("Deleting account with id: " + id);
        accountRepository.deleteById(id);
        System.out.println("Account deleted successfully!");
    }
}
