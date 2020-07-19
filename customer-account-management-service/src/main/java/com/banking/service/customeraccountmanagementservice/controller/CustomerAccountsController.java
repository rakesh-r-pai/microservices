package com.banking.service.customeraccountmanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.service.customeraccountmanagementservice.model.CustomerAccountResponseModel;
import com.banking.service.customeraccountmanagementservice.model.ExternalAccountBean;
import com.banking.service.customeraccountmanagementservice.model.InternalAccountBean;
import com.banking.service.customeraccountmanagementservice.service.ExternalAccountServiceProxy;
import com.banking.service.customeraccountmanagementservice.service.InternalAccountServiceProxy;

@RestController
public class CustomerAccountsController {
	
	@Autowired
	private InternalAccountServiceProxy internalProxy;
	
	@Autowired
	private ExternalAccountServiceProxy externalProxy;

	@GetMapping("/accounts")
	public CustomerAccountResponseModel fetchAccounts() {
		CustomerAccountResponseModel responseModel = new CustomerAccountResponseModel();
		InternalAccountBean internalAccount = internalProxy.fetchAccountDetails();
		responseModel.setInternalAccount(internalAccount);
		List<ExternalAccountBean> externalAccounts = externalProxy.fetchBeneficiaries();
		responseModel.setExternalAccounts(externalAccounts);
		return responseModel;
	}
}
