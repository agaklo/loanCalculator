package com.example.loanCalculator;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplication{
    @NotNull
    @NotBlank
    private String personalCode;
    @NotNull
    @Min(2000)
    @Max(10000)
	private Float  loanAmount;
    @NotNull
    @Min(12)
    @Max(60)
	private Long loanPeriod;
}