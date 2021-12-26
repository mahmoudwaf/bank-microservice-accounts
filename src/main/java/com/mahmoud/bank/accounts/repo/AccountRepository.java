package com.mahmoud.bank.accounts.repo;

import com.mahmoud.bank.accounts.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
    public Account findByAccountNumber(long accountNumber);
}
