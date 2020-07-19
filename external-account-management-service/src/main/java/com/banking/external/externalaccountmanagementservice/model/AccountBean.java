package com.banking.external.externalaccountmanagementservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountBean {

	@JsonIgnore
	private Long id;

	@NotEmpty(message = "bank name must not be empty")
	@Size(min = 5, max = 15, message = "bank name must be between 5 and 15 charactrs")
	private String bankName;

	@Size(min = 5, max = 5, message = "branch code must be 10 digits")
	@NotBlank(message = "branch code must not be blank")
	@NotEmpty(message = "branch code must not be empty")
	@NotNull(message = "branch code must not be null")
	private String branchCode;

	@NotEmpty(message = "name must not be empty")
	@Size(min = 5, max = 15, message = "name must be between 5 and 15 charactrs")
	private String beneficiaryName;

	@NotEmpty(message = "nick name must not be empty")
	@Size(min = 5, max = 10, message = "nick name must be between 5 and 10 charactrs")
	private String beneficiaryNickName;

	@Size(min = 10, max = 10, message = "account number must be 10 digits")
	@NotBlank(message = "account number must not be blank")
	@NotEmpty(message = "account number must not be empty")
	@NotNull(message = "account number must not be null")
	@Positive(message = "account number must be numberic")
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
