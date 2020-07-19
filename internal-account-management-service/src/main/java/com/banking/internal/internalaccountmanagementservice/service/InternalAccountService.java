/**
 * 
 */
package com.banking.internal.internalaccountmanagementservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banking.internal.internalaccountmanagementservice.dao.InternalAccountRepository;
import com.banking.internal.internalaccountmanagementservice.dao.entity.Bank;
import com.banking.internal.internalaccountmanagementservice.service.dto.InternalAccountServiceResponseDTO;
import com.banking.internal.internalaccountmanagementservice.service.helper.InternalAccountServiceHelper;

/**
 * Service class to invoke internal account details
 * 
 * @author Rakesh R Pai
 *
 */
@Component
public class InternalAccountService {

	@Autowired
	private InternalAccountRepository repository;

	public InternalAccountServiceResponseDTO fetchAccountDetails() {
		List<Bank> accounts = repository.findAll();
		InternalAccountServiceResponseDTO internalAccountServiceResponseDTO = InternalAccountServiceHelper.daoToDTOMapper
				.apply(accounts.get(0));
		return internalAccountServiceResponseDTO;
	}

}
