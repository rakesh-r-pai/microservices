package com.banking.service.customeraccountmanagementservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banking.service.customeraccountmanagementservice.model.InternalAccountBean;

@FeignClient(name="zuul-api-gateway-server", contextId="internalAccountServiceProxy")
@RibbonClient(name="internal-account-management-service")
@RequestMapping("/internal-account-management-service")
public interface InternalAccountServiceProxy {
	
	@GetMapping("/accounts")
	public InternalAccountBean fetchAccountDetails();

}
