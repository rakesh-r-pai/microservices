package com.banking.service.customeraccountmanagementservice.model;

import java.util.List;

public class CustomerAccountResponseModel {
	
	private InternalAccountBean internalAccount;
	
	private List<ExternalAccountBean> externalAccounts;

	/**
	 * @return the internalAccount
	 */
	public InternalAccountBean getInternalAccount() {
		return internalAccount;
	}

	/**
	 * @param internalAccount the internalAccount to set
	 */
	public void setInternalAccount(InternalAccountBean internalAccount) {
		this.internalAccount = internalAccount;
	}

	/**
	 * @return the externalAccounts
	 */
	public List<ExternalAccountBean> getExternalAccounts() {
		return externalAccounts;
	}

	/**
	 * @param externalAccounts the externalAccounts to set
	 */
	public void setExternalAccounts(List<ExternalAccountBean> externalAccounts) {
		this.externalAccounts = externalAccounts;
	}

}
