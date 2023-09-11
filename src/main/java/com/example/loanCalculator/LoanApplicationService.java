package com.example.loanCalculator;

import org.springframework.stereotype.Service;

@Service
public class LoanApplicationService {
    private final ClientRepository repository;
    private static final float MIN_SUM = 2000.00f;
    private static final float MAX_SUM = 10000.00f;
    private static final Long MIN_PERIOD = 12L;
    private static final Long MAX_PERIOD = 60L;

    LoanApplicationService(ClientRepository repository) {
        this.repository = repository;
    }

    public LoanScoringDecision scoreLoanApplication(LoanApplication loanApplication) {
        Client client = repository.findById(loanApplication.getPersonalCode())
                .orElseThrow(() -> new ClientNotFoundException(loanApplication.getPersonalCode()));

        LoanScoringDecision loanScoreDecision = new LoanScoringDecision();
        //scoring algorithm
        if (client.getSegment() == ClientSegmentEnum.DEBT) {
            //we do not approve for clients within DEBT segment
            return new LoanScoringDecision(false, 0.00f);
        } else {
            //we won't get loanAmount = 0 'cos of validation
            float creditScore = (client.getCreditModifier() / loanApplication.getLoanAmount())
                    * loanApplication.getLoanPeriod();
            if (creditScore < 1) {
                //declined
                loanScoreDecision.setGranted(false);
                loanScoreDecision.setLoanAmount(0.00f);
            } else {
                //approved
                loanScoreDecision.setGranted(true);

                //calculate loan amount to grant
                float amount = Math.max(MIN_SUM, loanApplication.getLoanAmount()); //must be greater than min
                amount = Math.min(MAX_SUM, amount); // must be lowet than max

                loanScoreDecision.setLoanAmount(amount);
            }
        }

        return loanScoreDecision;
    }

}
