package com.accountservice.dto;


import java.util.List;

public class AccountReportDTO {
    private Long accountId;
    private String accountNumber;
    private double balance;
    private List<TransactionReportDTO> transactions;

	public AccountReportDTO(Long accountId, String accountNumber, double balance,
			List<TransactionReportDTO> transactions) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactions = transactions;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<TransactionReportDTO> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionReportDTO> transactions) {
		this.transactions = transactions;
	}
    
}
