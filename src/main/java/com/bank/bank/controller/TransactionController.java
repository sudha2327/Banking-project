
package com.bank.bank.controller;
import com.bank.bank.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransferService service;

    public TransactionController(TransferService service) {
        this.service = service;
    }
    
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferRequest req){
    	
    	 service.transfer(req.fromAccount, req.toAccount, req.amount);
    	 return ResponseEntity.ok("Transfer succesful");
    			 
    }
 
    static class TransferRequest {
        public Long fromAccount;
        public Long toAccount;
        public double amount;
    }
    
}
