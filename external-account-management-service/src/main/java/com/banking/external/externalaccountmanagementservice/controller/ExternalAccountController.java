package com.banking.external.externalaccountmanagementservice.controller;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banking.external.externalaccountmanagementservice.controller.helper.ExternalAccountControllerHelper;
import com.banking.external.externalaccountmanagementservice.model.AccountBean;
import com.banking.external.externalaccountmanagementservice.service.ExternalAccountService;
import com.banking.external.externalaccountmanagementservice.service.dto.BeneficiaryDTO;
import com.banking.external.externalaccountmanagementservice.service.dto.BeneficiaryResponseDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ExternalAccountController {

	@Autowired
	private ExternalAccountService externalAccountService;

	@GetMapping("/beneficiaries")
	@HystrixCommand(fallbackMethod="fetchDefault")
	public List<AccountBean> fetchBeneficiaries() {
		BeneficiaryResponseDTO beneficiaries = externalAccountService.fetchBeneficiaries();
		return ExternalAccountControllerHelper.dtoToModelMapper.apply(beneficiaries);
	}

	@PostMapping("/beneficiaries")
	public ResponseEntity<HttpStatus> saveBeneficiary(@RequestBody @Valid AccountBean accountBean) {
		BeneficiaryDTO newBeneficiaryDTO = ExternalAccountControllerHelper.accountBeanToDTOMapper.apply(accountBean);
		BeneficiaryResponseDTO beneficiaryResponseDTO = externalAccountService.fetchBeneficiaries();
		boolean beneficiaryExists = ExternalAccountControllerHelper
				.checkForExistingBeneficiary(beneficiaryResponseDTO.getBeneficiaries(), newBeneficiaryDTO);
		if (beneficiaryExists) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		externalAccountService.saveBeneficiary(newBeneficiaryDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/beneficiaries/{id}")
	public ResponseEntity<HttpStatus> updateBeneficiary(@RequestBody AccountBean accountBean, @PathVariable Long id) {
		BeneficiaryDTO existingDTO = externalAccountService.fetchBeneficiaryById(id);
		if (nonNull(existingDTO)) {
			existingDTO.setBeneficiaryName(accountBean.getBeneficiaryName());
			existingDTO.setBeneficiaryNickName(accountBean.getBeneficiaryNickName());
			externalAccountService.saveBeneficiary(existingDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/beneficiaries/{id}")
	public ResponseEntity<HttpStatus> deleteBeneficiary(@PathVariable Long id) {
		try {
			externalAccountService.deleteBeneficiary(id);
		} catch (EmptyResultDataAccessException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public List<AccountBean> fetchDefault() {
		return new ArrayList<>();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
}
