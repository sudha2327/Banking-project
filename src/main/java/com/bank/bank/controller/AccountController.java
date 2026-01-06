
package com.bank.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bank.entity.Account;
import com.bank.bank.repository.AccountRepository;
import com.bank.bank.service.BalanceService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository repo;
    private final BalanceService balanceService;

    public AccountController(AccountRepository repo, BalanceService balanceService) {
        this.repo = repo;
        this.balanceService = balanceService;
    }

    @GetMapping("/ping")
    public String ping() {
    	 return "OK";
    }
    @PostMapping
    public Account create(@RequestBody Account a) {
        return repo.save(a);
    }

    @GetMapping("balance/{id}")
    public double balance(@PathVariable Long id) {
        return balanceService.getBalance(id);
    }
}
