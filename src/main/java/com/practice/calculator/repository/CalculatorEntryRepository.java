package com.practice.calculator.repository;

import com.practice.calculator.entity.CalculationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CalculatorEntryRepository extends JpaRepository<CalculationEntity, UUID> {
}
