package com.mahmoud.bank.accounts.controller;

import com.mahmoud.bank.accounts.entity.Account;
import com.mahmoud.bank.accounts.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/v1")
public class AccountController {

    @Autowired
    private AccountRepository repository;
    @GetMapping("/")
    public String home(){
        return "Welcome to Bank accounts API";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@RequestBody Account account){
         account =  repository.save(account);
        return "Account saved successfully with account number >>"+account.getAccountNumber();
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts(){
        return (List<Account>) repository.findAll();
    }

    @GetMapping("/getAccount/{accountNumber}")
    public Account getAccount(@PathVariable long accountNumber){
        System.out.println("getAccount called..");
        return repository.findByAccountNumber(accountNumber);
    }

}
