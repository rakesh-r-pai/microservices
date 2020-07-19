package com.banking.external.externalaccountmanagementservice.service.helper;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;

import com.banking.external.externalaccountmanagementservice.dao.entity.BeneficiaryAccount;
import com.banking.external.externalaccountmanagementservice.service.dto.BeneficiaryDTO;
import com.banking.external.externalaccountmanagementservice.service.dto.BeneficiaryResponseDTO;

public class ExternalAccountServiceHelper {

	public static final Function<List<BeneficiaryAccount>, BeneficiaryResponseDTO> processResponse = beneficiaries -> {
		BeneficiaryResponseDTO beneficiaryResponseDTO = new BeneficiaryResponseDTO();
		List<BeneficiaryDTO> beneficiariesDTO = null;
		if (nonNull(beneficiaries) && !beneficiaries.isEmpty()) {
			beneficiariesDTO = new ArrayList<>();
			for (BeneficiaryAccount beneficiary : beneficiaries) {
				BeneficiaryDTO beneficiaryDTO = new BeneficiaryDTO();
				BeanUtils.copyProperties(beneficiary, beneficiaryDTO);
				beneficiariesDTO.add(beneficiaryDTO);
			}
		}
		beneficiaryResponseDTO.setBeneficiaries(beneficiariesDTO);
		return beneficiaryResponseDTO;
	};

	public static final Function<BeneficiaryDTO, BeneficiaryAccount> dtoToDAOMapper = beneficiaryDTO -> {
		BeneficiaryAccount beneficiaryAccount = new BeneficiaryAccount();
		BeanUtils.copyProperties(beneficiaryDTO, beneficiaryAccount);
		return beneficiaryAccount;
	};
	
	public static final Function<BeneficiaryAccount, BeneficiaryDTO> daoToDTOMapper = beneficiaryAccount -> {
		BeneficiaryDTO beneficiaryDTO = new BeneficiaryDTO();
		BeanUtils.copyProperties(beneficiaryAccount, beneficiaryDTO);
		return beneficiaryDTO;
	};
}
