package com.hoolah.app.model;

public class AnalyserOut {

	private int numberOfTransactions;
	private float averageTransactionValue;
	
	public AnalyserOut(int numberOfTransactions, float averageTransactionValue) {
		super();
		this.numberOfTransactions = numberOfTransactions;
		this.averageTransactionValue = averageTransactionValue;
	}
	
	public AnalyserOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	public final int getNumberOfTransactions() {
		return numberOfTransactions;
	}
	public final float getAverageTransactionValue() {
		return averageTransactionValue;
	}
	public final void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}
	public final void setAverageTransactionValue(float averageTransactionValue) {
		this.averageTransactionValue = averageTransactionValue;
	}
	@Override
	public String toString() {
		return "AnalyserOut [numberOfTransactions=" + numberOfTransactions + ", averageTransactionValue="
				+ averageTransactionValue + "]";
	}
	
}
