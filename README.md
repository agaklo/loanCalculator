1. run service spring boot 3:

gradlew bootRun

function's endpoint which decide if loan is approved:

http://localhost:8080/loan/application

2. run client app angular

first install node modules, directory: loan-calculator
 
npm install -g @angular/cli

then serve app:

 ng serve --open

app starts at http://localhost:4200/

Important:
1. In angular app inside src/app/loan-application.component.ts endpoint decision address is set to http://localhost:8080/loan/application
(in case endpoint's address change, it's important to change here)

2. In spring boot 3 app, in LoanApplicationControler is set: 
 @CrossOrigin(origins = "http://localhost:4200/")  
- this allows to call service from other webbrowser's addres - normally is forbidden, 'cos of CrossOrigin mechanism; 
if start's address for angular app change (http://localhost:4200), this should be change to new address  

3. pay attention: node modules in loan-application/node_modules are large and it's good idea to remove them (before sending) (i.e. rm -rf node_modules); 
to restore them before running use: npm install

