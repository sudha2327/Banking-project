
package com.bank.bank.service;
import com.bank.bank.repository.LedgerRepository;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    private final LedgerRepository repo;

    public BalanceService(LedgerRepository repo) {
        this.repo = repo;
    }

    public double getBalance(Long accountId) {
        return repo.findByAccountId(accountId).stream()
            .mapToDouble(e -> e.getType().equals("CREDIT") ? e.getAmount() : -e.getAmount())
            .sum();
    }
}
