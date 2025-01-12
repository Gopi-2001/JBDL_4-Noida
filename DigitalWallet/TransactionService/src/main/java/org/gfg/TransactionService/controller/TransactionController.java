package org.gfg.TransactionService.controller;

import org.gfg.TransactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction-service")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @GetMapping("/initiate/transaction")
    public String createTransaction(@RequestParam("amount") String amount,
                                    @RequestParam("purpose") String purpose,
                                    @RequestParam("receiver") String receiver){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String sender = userDetails.getUsername();
        String txnId = transactionService.initiateTransaction(sender,receiver,purpose,amount);
        return txnId;
    }
}
