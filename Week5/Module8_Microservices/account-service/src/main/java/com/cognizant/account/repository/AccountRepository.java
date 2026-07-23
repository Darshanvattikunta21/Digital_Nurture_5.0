// this interface gives me all the CRUD methods for free
// I dont need to write any SQL queries
// Spring Data JPA will automatically create the implementation
package com.cognizant.account.repository;

import com.cognizant.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // find account by account number
    // Spring will automatically write SQL for this
    Optional<Account> findByAccountNumber(String accountNumber);

    // find all accounts of a person
    List<Account> findByAccountHolderName(String accountHolderName);

    // find accounts by type
    List<Account> findByAccountType(String accountType);
}
