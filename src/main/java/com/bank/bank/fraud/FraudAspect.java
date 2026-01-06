
package com.bank.bank.fraud;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FraudAspect {
    @Before("execution(* com.fintech.service.TransferService.transfer(..)) && args(from,to,amount)")
    public void check(Long from, Long to, double amount) {
        if (amount > 50000) {
            System.out.println("FRAUD ALERT: 2FA REQUIRED");
        }
    }
}
