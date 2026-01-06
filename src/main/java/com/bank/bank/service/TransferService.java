
package com.bank.bank.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.bank.entity.LedgerEntry;
import com.bank.bank.repository.LedgerRepository;

import YPE.LedgerType;

import org.springframework.transaction.annotation.Isolation;

@Service
public class TransferService {
    private final LedgerRepository repo;

    public TransferService(LedgerRepository repo) {
        this.repo = repo;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void transfer(Long from, Long to, double amount) {
        LedgerEntry debit = new LedgerEntry();
        debit.setAccountId(from);
        debit.setType(LedgerType.DEBIT);
        debit.setAmount(amount);

        LedgerEntry credit = new LedgerEntry();
        credit.setAccountId(to);
        credit.setType(LedgerType.CREDIT);
        credit.setAmount(amount);
        repo.save(debit);
        repo.save(credit);
    }
}
