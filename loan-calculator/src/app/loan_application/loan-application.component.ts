import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoanApplication } from './loan-application';

@Component({
  selector: 'app-loan-application-form',
  templateUrl: './loan-application.component.html',
  styleUrls: ['./loan-application.component.css'],

})
export class LoanApplicationFormComponent implements OnInit {
  constructor(private http: HttpClient) {

  }
  ngOnInit() {}

  model = new LoanApplication('49002010965', 2000.00, 12, false, 0);
  submitted = false;

  onSubmit() {
   let data = {
    personalCode: this.model.personalCode,
    loanAmount:  this.model.loanAmount,
    loanPeriod:  this.model.loanPeriod,
   }
    this.http.post('http://localhost:8080/loan/application', data, {responseType:'json'}).subscribe(
      (response: any) => {
        this.model.granted = response.granted;
        this.model.grantedLoanAmount = response.loanAmount;
        console.log(response);

        this.submitted = true;
      },
      (error) => {
        console.log(error.message);
      }
    );

  }

  newLoanApplication() {
    this.model = new LoanApplication("49002010965", 2000.00, 12, false, 0);
  }
}
