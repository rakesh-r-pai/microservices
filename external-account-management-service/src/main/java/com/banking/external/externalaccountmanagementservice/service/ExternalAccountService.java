package com.banking.external.externalaccountmanagementservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banking.external.externalaccountmanagementservice.dao.ExternalAccountRepository;
import com.banking.external.externalaccountmanagementservice.dao.entity.BeneficiaryAccount;
import com.banking.external.externalaccountmanagementservice.service.dto.BeneficiaryDTO;
import com.banking.external.externalaccountmanagementservice.service.dto.BeneficiaryResponseDTO;
import com.banking.external.externalaccountmanagementservice.service.helper.ExternalAccountServiceHelper;

@Component
public class ExternalAccountService {

	@Autowired
	private ExternalAccountRepository repository;

	public BeneficiaryResponseDTO fetchBeneficiaries() {
		List<BeneficiaryAccount> beneficiaries = repository.findAll();
		return ExternalAccountServiceHelper.processResponse.apply(beneficiaries);
	}

	public BeneficiaryDTO fetchBeneficiaryById(Long id) {
		Optional<BeneficiaryAccount> beneficiaryOptional = repository.findById(id);
		BeneficiaryDTO beneficiaryDTO = null;
		if (beneficiaryOptional.isPresent()) {
			beneficiaryDTO = ExternalAccountServiceHelper.daoToDTOMapper.apply(beneficiaryOptional.get());
		}
		return beneficiaryDTO;
	}

	public void saveBeneficiary(BeneficiaryDTO beneficiaryDTO) {
		BeneficiaryAccount beneficiaryAccount = ExternalAccountServiceHelper.dtoToDAOMapper.apply(beneficiaryDTO);
		repository.save(beneficiaryAccount);
	}

	public void deleteBeneficiary(Long id) {
		repository.deleteById(id);
	}
}
