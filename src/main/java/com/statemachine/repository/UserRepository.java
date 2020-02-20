package com.statemachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.statemachine.entity.Customers;

@Repository
public interface UserRepository extends JpaRepository<Customers,Long>{
	Customers findByMobileAndPassword(String mobile, String password);	
}
