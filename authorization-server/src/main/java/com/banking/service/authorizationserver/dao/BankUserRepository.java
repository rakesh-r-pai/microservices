package com.banking.service.authorizationserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.service.authorizationserver.dao.entity.BankUser;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Long>{

	BankUser findByUsername(String username);
}
