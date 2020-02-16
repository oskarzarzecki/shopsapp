package com.oskiapps.shopsapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oskiapps.shopsapp.model.entities.CustomerAccount;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

	boolean existsByEmail(String email);

	Optional<CustomerAccount> findByEmail(String username);

}
