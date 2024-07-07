package com.accountservice.dto;

import java.util.List;

public class AccountStatementReportDTO {
    private Long customerId;
    private List<AccountReportDTO> accounts;
	
	public AccountStatementReportDTO(Long customerId, List<AccountReportDTO> accounts) {
		super();
		this.customerId = customerId;
		this.accounts = accounts;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<AccountReportDTO> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<AccountReportDTO> accounts) {
		this.accounts = accounts;
	}
    
}