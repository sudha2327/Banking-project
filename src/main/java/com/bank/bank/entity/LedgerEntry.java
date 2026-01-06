
package com.bank.bank.entity;

import jakarta.persistence.*;
import java.time.Instant;

import YPE.LedgerType;

@Entity
public class LedgerEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;
    @Enumerated(EnumType.STRING)
    private LedgerType type;
    private double amount;
    private Instant timestamp = Instant.now();

    public Long getAccountId() { return accountId; }
    public LedgerType getType() { return type; }
    public double getAmount() { return amount; }

    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public void setType(LedgerType type) { this.type = type; }
    public void setAmount(double amount) { this.amount = amount; }
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	public void setType(String string) {
		// TODO Auto-generated method stub
		
		
	}
}
