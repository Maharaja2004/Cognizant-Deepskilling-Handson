package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;

@RestController
public class LoanController {
   
	 @GetMapping("/loans/{number}")
	    public Loan getLoan(@PathVariable String number) {
	        return new Loan(number,500000,5);
	    }
}
