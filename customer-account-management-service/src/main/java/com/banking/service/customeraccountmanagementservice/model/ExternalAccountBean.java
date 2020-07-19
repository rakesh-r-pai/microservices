package com.banking.service.customeraccountmanagementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExternalAccountBean {

	@JsonIgnore
	private Long id;

	private String bankName;

	private String branchCode;

	private String beneficiaryName;

	private String beneficiaryNickName;

	private String accountNumber;

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
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the beneficiaryName
	 */
	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	/**
	 * @param beneficiaryName the beneficiaryName to set
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	/**
	 * @return the beneficiaryNickName
	 */
	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}

	/**
	 * @param beneficiaryNickName the beneficiaryNickName to set
	 */
	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
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
	
}
