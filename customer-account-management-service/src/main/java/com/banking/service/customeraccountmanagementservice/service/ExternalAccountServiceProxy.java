package com.banking.service.customeraccountmanagementservice.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banking.service.customeraccountmanagementservice.model.ExternalAccountBean;

@FeignClient(name="zuul-api-gateway-server", contextId="externalAccountServiceProxy")
@RibbonClient(name="external-account-management-service")
@RequestMapping("/external-account-management-service")
public interface ExternalAccountServiceProxy {

	@GetMapping("/beneficiaries")
	public List<ExternalAccountBean> fetchBeneficiaries();
}
