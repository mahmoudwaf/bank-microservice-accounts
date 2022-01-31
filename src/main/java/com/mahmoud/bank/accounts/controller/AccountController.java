package com.mahmoud.bank.accounts.controller;

import com.mahmoud.bank.accounts.config.AccountsConfig;
import com.mahmoud.bank.accounts.config.Properties;
import com.mahmoud.bank.accounts.entity.Account;
import com.mahmoud.bank.accounts.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/v1")
public class AccountController {

    @Autowired
    private AccountRepository repository;
    @Autowired
    private AccountsConfig accountsConfig;
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

    @GetMapping("/properties")
    public ResponseEntity<Properties> getProperties(){
        Properties props = new Properties();
        props.setPort(accountsConfig.getPort());
        props.setQaMessage(accountsConfig.getMsg().get("qa"));
        props.setTestMessage(accountsConfig.getMsg().get("test"));
        return new ResponseEntity<Properties>(props, HttpStatus.OK);
    }

}
