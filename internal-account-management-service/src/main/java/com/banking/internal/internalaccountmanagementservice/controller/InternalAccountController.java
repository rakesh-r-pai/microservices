/**
 * Copyright of Cognizant
 */
package com.banking.internal.internalaccountmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.internal.internalaccountmanagementservice.controller.helper.InternalAccountControllerHelper;
import com.banking.internal.internalaccountmanagementservice.model.AccountBean;
import com.banking.internal.internalaccountmanagementservice.service.InternalAccountService;
import com.banking.internal.internalaccountmanagementservice.service.dto.InternalAccountServiceResponseDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Controller class to invoke internal account details
 * 
 * @author Rakesh R Pai
 *
 */
@RestController
public class InternalAccountController {

	@Autowired
	private InternalAccountService internalAccountService;

	@GetMapping("/accounts")
	@HystrixCommand(fallbackMethod="fetchDefault")
	public AccountBean fetchAccountDetails() {
		InternalAccountServiceResponseDTO internalAccountServiceResponseDTO = internalAccountService
				.fetchAccountDetails();
		AccountBean accountBean = InternalAccountControllerHelper.dtoToModelMapper
				.apply(internalAccountServiceResponseDTO);
		return accountBean;
	}
	
	public AccountBean fetchDefault() {
		return new AccountBean();
	}
}
