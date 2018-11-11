# TransactionAnalyzer
A Simple Spring Boot application to analysis transactions

Project Structure :

How to Run:

A simplified financial transaction analysis system.
The goal of the system is to display statistic information about processed transaction

Application has three End points

1 => http://localhost:8080/transaction/

Landing Screen

2 => http://localhost:8080/transaction/all

To get all transactions

3 => http://localhost:8080/transaction/analyse?fromDate={From Date}&toDate={To Date}&merchant={Merchand Name}

To Analysis the historical transactions based on provided date range

example url : 

http://localhost:8080/transaction/analyse?fromDate=20/08/2018%2012:45:33&toDate=20/08/2018%2014:07:10&merchant=MacLaren


