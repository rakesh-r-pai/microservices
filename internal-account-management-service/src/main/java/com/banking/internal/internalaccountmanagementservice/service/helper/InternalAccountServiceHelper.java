/**
 * 
 */
package com.banking.internal.internalaccountmanagementservice.service.helper;

import java.util.function.Function;

import com.banking.internal.internalaccountmanagementservice.dao.entity.Bank;
import com.banking.internal.internalaccountmanagementservice.service.dto.InternalAccountServiceResponseDTO;

/**
 * @author student
 *
 */
public class InternalAccountServiceHelper {

	public static final Function<Bank, InternalAccountServiceResponseDTO> daoToDTOMapper = bank -> {
		InternalAccountServiceResponseDTO internalAccountServiceResponseDTO = new InternalAccountServiceResponseDTO();
		internalAccountServiceResponseDTO.setBankName(bank.getBankName());
		internalAccountServiceResponseDTO.setAccountNumber(bank.getAccount().getAccountNumber());
		internalAccountServiceResponseDTO.setAccountBalance(bank.getAccount().getAccountBalance());
		return internalAccountServiceResponseDTO;
	};

}
