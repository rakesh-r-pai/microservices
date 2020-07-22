/**
 * 
 */
package com.banking.internal.internalaccountmanagementservice.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Placeholder for bank details
 * 
 * @author Rakesh R Pai
 *
 */
@Entity
public class Bank {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String bankName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	
	public Bank() {
		//Constructor
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
