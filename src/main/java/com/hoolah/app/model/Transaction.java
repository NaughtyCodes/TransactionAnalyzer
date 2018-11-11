package com.hoolah.app.model;

import java.util.Date;

public class Transaction  {
	
	private String id;
	private Date date;
	private float amount;
	private String merchant;
	private String type;
	private String relatedTransaction;
	
	public Transaction(String id, Date date, float amount, String merchant, String type, String relatedTransaction) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.merchant = merchant;
		this.type = type;
		this.relatedTransaction = relatedTransaction;
	}
	public final String getId() {
		return id;
	}
	public final Date getDate() {
		return date;
	}
	public final float getAmount() {
		return amount;
	}
	public final String getMerchant() {
		return merchant;
	}
	public final String getType() {
		return type;
	}
	public final String getRelatedTransaction() {
		return relatedTransaction;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final void setDate(Date date) {
		this.date = date;
	}
	public final void setAmount(float amount) {
		this.amount = amount;
	}
	public final void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public final void setType(String type) {
		this.type = type;
	}
	public final void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", merchant=" + merchant + ", type=" + type
				+ ", relatedTransaction=" + relatedTransaction + "]";
	}
	

	
}
