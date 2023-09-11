package com.example.loanCalculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanScoringDecision {
    private boolean isGranted;
	private Float  loanAmount;
}
