package com.hoolah.app.model;

import java.util.List;

import org.springframework.stereotype.Component;

public class TransactionHistoryList {
	
	public List<Transaction> transactions;

	public TransactionHistoryList(List<Transaction> transactions) {
		super();
		this.transactions = transactions;
	}

	public final List<Transaction> getTransactions() {
		return transactions;
	}

	
}
