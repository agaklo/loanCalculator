export class LoanApplication {

    constructor(
      public personalCode: string,
      public loanAmount: number,
      public loanPeriod: number,
      public granted: boolean,
      public grantedLoanAmount: number
    ) {  }
  
  }