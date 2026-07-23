// this is the REST controller for account microservice
// it handles all HTTP requests for accounts
package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import com.cognizant.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// @RestController means this class handles REST API requests
@RestController
// @RequestMapping is the base URL for all endpoints in this controller
@RequestMapping("/api/accounts")
public class AccountController {

    // inject the service
    @Autowired
    private AccountService accountService;

    // GET /api/accounts - get all accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        System.out.println("GET /api/accounts - getting all accounts");
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // GET /api/accounts/1 - get account by id
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        System.out.println("GET /api/accounts/" + id);
        try {
            Account account = accountService.getAccountById(id);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET /api/accounts/number/ACC001 - get account by number
    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        System.out.println("GET /api/accounts/number/" + accountNumber);
        try {
            Account account = accountService.getAccountByNumber(accountNumber);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST /api/accounts - create new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        System.out.println("POST /api/accounts - creating account for: " + account.getAccountHolderName());
        Account savedAccount = accountService.createAccount(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    // PUT /api/accounts/1 - update account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        System.out.println("PUT /api/accounts/" + id);
        try {
            Account updatedAccount = accountService.updateAccount(id, account);
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /api/accounts/1 - delete account
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        System.out.println("DELETE /api/accounts/" + id);
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
