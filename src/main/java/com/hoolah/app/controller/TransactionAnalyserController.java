package com.hoolah.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoolah.app.model.AnalyserOut;
import com.hoolah.app.model.Transaction;
import com.hoolah.app.model.TransactionHistoryList;

@RestController
@RequestMapping("/transaction")
public class TransactionAnalyserController {
	
	@Autowired
	public TransactionHistoryList transactionHistoryList;
	
	@RequestMapping("/")
	public String getHome() {
		return "Wecome To Transaction Analyser";
	}
	
	@RequestMapping("/all")
	public List<Transaction> getAllTransactions() {
		
		List<Transaction> transactions = transactionHistoryList.getTransactions(); 
		Collections.sort(transactions,
			new Comparator<Transaction>() {
				public int compare(Transaction t1, Transaction t2) {
					return t1.getDate().compareTo(t2.getDate());
				}
			});
		
		return transactions;
	}
	
	@RequestMapping("/analyse")
	public AnalyserOut getAllTransactions(
			@RequestParam String fromDate,
			@RequestParam String toDate,
			@RequestParam String merchant
			) throws ParseException {
		
		int numberOfTransactions = 0;
		float averageTransactionValue = 0;
		AnalyserOut analyserOut = new AnalyserOut();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy hh:mm:ss");
		Date fDate = dateFormat.parse(fromDate);
		Date tDate = dateFormat.parse(toDate);
		
		Set<String> relatedTransactions = transactionHistoryList.getTransactions().stream()
				.filter(t->!t.getRelatedTransaction().isEmpty())
				.map(t->t.getRelatedTransaction().trim())
				.collect(Collectors.toSet());
		
		List<Transaction> collect = transactionHistoryList.getTransactions().stream()
			.filter(t->t.getMerchant().trim().equalsIgnoreCase(merchant.trim()))
			.filter(t->t.getDate().after(fDate) || t.getDate().equals(fDate))
			.filter(t->t.getDate().before(tDate) || t.getDate().equals(tDate))
			.filter(t->!relatedTransactions.contains(t.getId().trim()))
			.collect(Collectors.toList());
		
		collect.forEach(t->{
			analyserOut.setAverageTransactionValue(analyserOut.getAverageTransactionValue() + t.getAmount());
		});
		
		numberOfTransactions = collect.size();
		averageTransactionValue = (analyserOut.getAverageTransactionValue()/numberOfTransactions);
		analyserOut.setNumberOfTransactions(numberOfTransactions);
		analyserOut.setAverageTransactionValue(averageTransactionValue);
		
		return analyserOut;
		
	}

}
