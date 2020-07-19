package com.banking.external.externalaccountmanagementservice.service.dto;

import java.util.List;

public class BeneficiaryResponseDTO {
	
	private List<BeneficiaryDTO> beneficiaries;

	/**
	 * @return the beneficiaries
	 */
	public List<BeneficiaryDTO> getBeneficiaries() {
		return beneficiaries;
	}

	/**
	 * @param beneficiaries the beneficiaries to set
	 */
	public void setBeneficiaries(List<BeneficiaryDTO> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	
}
