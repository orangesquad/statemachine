package com.statemachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.statemachine.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Long>{
}
