/**
 * Copyright of Cognizant
 */
package com.banking.internal.internalaccountmanagementservice.model;

import java.math.BigDecimal;

/**
 * Model to hold internal account details
 * 
 * @author Rakesh R Pai
 *
 */
public class AccountBean {
	
	private String bankName;
	
	private String accountNumber;
	
	private BigDecimal accountBalance;

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountBalance
	 */
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
