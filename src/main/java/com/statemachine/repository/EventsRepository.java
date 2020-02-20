package com.statemachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.statemachine.entity.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long>{
}
