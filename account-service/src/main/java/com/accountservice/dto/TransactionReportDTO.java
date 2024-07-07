package com.accountservice.dto;

import java.time.LocalDateTime;

public class TransactionReportDTO {
    private LocalDateTime date;
    private String transactionType;
    private double amount;
    private double balance;

	public TransactionReportDTO(LocalDateTime date, String transactionType, double amount, double balance) {
		super();
		this.date = date;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    
}
