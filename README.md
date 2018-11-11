# TransactionAnalyzer

A Simple Spring Boot application to analyse financial transactions
The goal of the system is to display statistic information about processed transaction

## https://github.com/NaughtyCodes/TransactionAnalyzer/wiki

Application has three End points

1 => http://localhost:8080/transaction/

Landing Screen

2 => http://localhost:8080/transaction/all

To get all transactions

3 => http://localhost:8080/transaction/analyse?fromDate={FromDate}&toDate={ToDate}&merchant={MerchandName}

To Analysis the historical transactions based on provided date range

example url : 

http://localhost:8080/transaction/analyse?fromDate=20/08/2018%2012:45:33&toDate=20/08/2018%2014:07:10&merchant=MacLaren


