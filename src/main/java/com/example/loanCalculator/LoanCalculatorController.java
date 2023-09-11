package com.example.loanCalculator;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanCalculatorController {
    private final LoanApplicationService loanApplicationService;

    LoanCalculatorController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @RequestMapping(value = "/loan/application", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<LoanScoringDecision> scoreLoanApplication(@Valid @RequestBody LoanApplication loanApplication) {
        return new ResponseEntity<>(
                loanApplicationService.scoreLoanApplication(loanApplication), HttpStatus.OK);
    }

}
