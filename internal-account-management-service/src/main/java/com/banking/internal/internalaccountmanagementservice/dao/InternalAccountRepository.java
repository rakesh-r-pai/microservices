/**
 * 
 */
package com.banking.internal.internalaccountmanagementservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.internal.internalaccountmanagementservice.dao.entity.Bank;

/**
 * Repository to invoke internal account details
 * 
 * @author Rakesh R Pai
 *
 */
@Repository
public interface InternalAccountRepository extends JpaRepository<Bank, Long>{

}
