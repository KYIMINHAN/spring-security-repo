package com.kyiminhan.spring.repository;

import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyiminhan.spring.entity.Account;

@Lazy
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByEmail();

}