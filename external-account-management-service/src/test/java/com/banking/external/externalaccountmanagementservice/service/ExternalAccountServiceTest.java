package com.banking.external.externalaccountmanagementservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.banking.external.externalaccountmanagementservice.dao.ExternalAccountRepository;
import com.banking.external.externalaccountmanagementservice.dao.entity.BeneficiaryAccount;
import com.banking.external.externalaccountmanagementservice.service.dto.BeneficiaryDTO;
import com.banking.external.externalaccountmanagementservice.service.dto.BeneficiaryResponseDTO;

@RunWith(PowerMockRunner.class)
@PrepareForTest
public class ExternalAccountServiceTest {

	@InjectMocks
	private ExternalAccountService service;

	@Mock
	private ExternalAccountRepository repository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFetchBeneficiaries() {
		List<BeneficiaryAccount> beneficiaries = populateBeneficiaries();
		Mockito.when(repository.findAll()).thenReturn(beneficiaries);
		BeneficiaryResponseDTO responseDTO = service.fetchBeneficiaries();
		assertNotNull(responseDTO);
		assertNotNull(responseDTO.getBeneficiaries());
		assertFalse(responseDTO.getBeneficiaries().isEmpty());
		assertEquals("2020101020", responseDTO.getBeneficiaries().get(0).getAccountNumber());
		assertEquals("RST Bank", responseDTO.getBeneficiaries().get(0).getBankName());
		assertEquals("Sommerset", responseDTO.getBeneficiaries().get(0).getBeneficiaryName());
		assertEquals("Sunny", responseDTO.getBeneficiaries().get(0).getBeneficiaryNickName());
		assertEquals("RST01", responseDTO.getBeneficiaries().get(0).getBranchCode());
		assertEquals("1", responseDTO.getBeneficiaries().get(0).getId().toString());
	}

	@Test
	public void testFetchBeneficiaryById() {
		BeneficiaryAccount beneficiaryAccount = populateBeneficiaries().get(0);
		Mockito.when(repository.findById(anyLong())).thenReturn(Optional.of(beneficiaryAccount));
		BeneficiaryDTO beneficiaryDTO = service.fetchBeneficiaryById(1L);
		assertNotNull(beneficiaryDTO);
		assertEquals("2020101020", beneficiaryDTO.getAccountNumber());
		assertEquals("RST Bank", beneficiaryDTO.getBankName());
		assertEquals("Sommerset", beneficiaryDTO.getBeneficiaryName());
		assertEquals("Sunny", beneficiaryDTO.getBeneficiaryNickName());
		assertEquals("RST01", beneficiaryDTO.getBranchCode());
		assertEquals("1", beneficiaryDTO.getId().toString());
	}
	
	@Test
	public void testFetchBeneficiaryById_whenBeneficiaryIsNull() {
		List<BeneficiaryAccount> beneficiaries = new ArrayList<>();
		Optional<BeneficiaryAccount> beneficiaryAccount = beneficiaries.stream().findFirst();
		Mockito.when(repository.findById(anyLong())).thenReturn(beneficiaryAccount);
		BeneficiaryDTO beneficiaryDTO = service.fetchBeneficiaryById(1L);
		assertNull(beneficiaryDTO);
	}

	@Test
	public void testSaveBeneficiary() {
		BeneficiaryDTO beneficiaryDTO = populateDTO();
		BeneficiaryAccount beneficiary = new BeneficiaryAccount();
		Mockito.when(repository.save(Mockito.any(BeneficiaryAccount.class))).thenReturn(beneficiary);
		service.saveBeneficiary(beneficiaryDTO);
		assertNotNull(beneficiary);
	}

	@Test
	public void testDeleteBeneficiary() {
		Long id = 1L;
		Mockito.doNothing().when(repository).deleteById(id);
		assertEquals("1", id.toString());
	}

	private BeneficiaryDTO populateDTO() {
		BeneficiaryDTO beneficiaryDTO = new BeneficiaryDTO();
		beneficiaryDTO.setAccountNumber("2020101020");
		beneficiaryDTO.setBankName("RST Bank");
		beneficiaryDTO.setBeneficiaryName("Sommerset");
		beneficiaryDTO.setBeneficiaryNickName("Sunny");
		beneficiaryDTO.setBranchCode("RST01");
		beneficiaryDTO.setId(1L);
		return beneficiaryDTO;
	}

	private List<BeneficiaryAccount> populateBeneficiaries() {
		List<BeneficiaryAccount> beneficiaries = new ArrayList<>();
		BeneficiaryAccount beneficiaryAccount = new BeneficiaryAccount();
		beneficiaryAccount.setAccountNumber("2020101020");
		beneficiaryAccount.setBankName("RST Bank");
		beneficiaryAccount.setBeneficiaryName("Sommerset");
		beneficiaryAccount.setBeneficiaryNickName("Sunny");
		beneficiaryAccount.setBranchCode("RST01");
		beneficiaryAccount.setId(1L);
		beneficiaries.add(beneficiaryAccount);
		return beneficiaries;
	}

}
