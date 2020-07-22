package com.banking.internal.internalaccountmanagementservice.controller.helper;

import java.util.Collections;
import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.banking.internal.internalaccountmanagementservice.model.AccountBean;
import com.banking.internal.internalaccountmanagementservice.service.dto.InternalAccountServiceResponseDTO;

public class InternalAccountControllerHelper {
	
	private InternalAccountControllerHelper() {
		//Private Constructor
	}

	public static final Function<InternalAccountServiceResponseDTO, AccountBean> dtoToModelMapper = internalAccountServiceResponseDTO -> {
		AccountBean accountBean = new AccountBean();
		accountBean.setBankName(internalAccountServiceResponseDTO.getBankName());
		accountBean.setAccountNumber(!StringUtils.isEmpty(internalAccountServiceResponseDTO.getAccountNumber())
				? maskAccount(internalAccountServiceResponseDTO.getAccountNumber())
				: internalAccountServiceResponseDTO.getAccountNumber());
		accountBean.setAccountBalance(internalAccountServiceResponseDTO.getAccountBalance());
		return accountBean;
	};

	public static String maskAccount(String accountnumber) {
		return accountnumber.substring(0, 4) + String.join("", Collections.nCopies(6, "X"));
	}
}
