package com.practice.calculator.service;

import com.practice.calculator.dto.CalculatorRequestDTO;
import com.practice.calculator.dto.CalculatorResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalculatorI
{
    CalculatorResponseDTO add(CalculatorRequestDTO calculatorRequest);
    CalculatorResponseDTO sub(CalculatorRequestDTO callingInputs);
    CalculatorResponseDTO mul(CalculatorRequestDTO callingInputs);
    CalculatorResponseDTO div(CalculatorRequestDTO callingInputs);

    List<CalculatorResponseDTO> history();

    CalculatorResponseDTO save(CalculatorResponseDTO calculatorResponse);

    List<CalculatorResponseDTO> historyByPAge(Pageable pageable);
}

