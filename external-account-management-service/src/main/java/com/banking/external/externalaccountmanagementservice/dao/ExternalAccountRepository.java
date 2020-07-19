package com.banking.external.externalaccountmanagementservice.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.external.externalaccountmanagementservice.dao.entity.BeneficiaryAccount;

@Repository
@Transactional
public interface ExternalAccountRepository extends JpaRepository<BeneficiaryAccount, Long>{

}
