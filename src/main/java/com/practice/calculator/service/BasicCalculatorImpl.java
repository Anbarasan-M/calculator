package com.practice.calculator.service;

import com.practice.calculator.dto.CalculatorRequestDTO;
import com.practice.calculator.dto.CalculatorResponseDTO;
import com.practice.calculator.entity.CalculationEntity;
import com.practice.calculator.mapper.CalculationEntryMapper;
import com.practice.calculator.repository.CalculatorEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BasicCalculatorImpl implements CalculatorI
{

    @Autowired
    CalculatorEntryRepository calculatorEntryRepository;

    @Autowired
    CalculationEntryMapper calculationEntryMapper;
    @Override
    public CalculatorResponseDTO add(CalculatorRequestDTO calculatorRequest) {
        CalculatorResponseDTO calculatorResponse = CalculatorResponseDTO.builder().
                id(UUID.randomUUID()).
                data1(calculatorRequest.getData1()).
                data2(calculatorRequest.getData2()).
                operand(calculatorRequest.getOperand()).build();

        calculatorResponse.setResult(calculatorResponse.getData1()+calculatorResponse.getData2());

        return save(calculatorResponse);
    }

    @Override
    public CalculatorResponseDTO sub(CalculatorRequestDTO calculatorRequest) {
        CalculatorResponseDTO calculatorResponse = CalculatorResponseDTO.builder().
                id(UUID.randomUUID()).
                data1(calculatorRequest.getData1()).
                data2(calculatorRequest.getData2()).
                operand(calculatorRequest.getOperand()).build();

        calculatorResponse.setResult(calculatorResponse.getData1()-calculatorResponse.getData2());

        return save(calculatorResponse);
    }

    @Override
    public CalculatorResponseDTO mul(CalculatorRequestDTO calculatorRequest) {
        CalculatorResponseDTO calculatorResponse = CalculatorResponseDTO.builder().
                id(UUID.randomUUID()).
                data1(calculatorRequest.getData1()).
                data2(calculatorRequest.getData2()).
                operand(calculatorRequest.getOperand()).build();

        calculatorResponse.setResult(calculatorResponse.getData1() * calculatorResponse.getData2());

        return save(calculatorResponse);
    }

        @Override
    public CalculatorResponseDTO div(CalculatorRequestDTO calculatorRequest) {
        CalculatorResponseDTO calculatorResponse = CalculatorResponseDTO.builder().
                id(UUID.randomUUID()).
                data1(calculatorRequest.getData1()).
                data2(calculatorRequest.getData2()).
                operand(calculatorRequest.getOperand()).build();

        calculatorResponse.setResult(calculatorResponse.getData1()/calculatorResponse.getData2());

        return save(calculatorResponse);
    }

    @Override
    public List<CalculatorResponseDTO> history() {
      return calculationEntryMapper.toListCalculatorResponse(calculatorEntryRepository.findAll()) ;
    }

    @Override
    public CalculatorResponseDTO save(CalculatorResponseDTO calculatorResponse){
        CalculationEntity calculationEntity = calculationEntryMapper.toCalculationEntity(calculatorResponse);
        calculationEntity.setExecution_time(LocalDateTime.now());
        calculatorResponse =
                calculationEntryMapper.toCalculatorResponse( calculatorEntryRepository.save(calculationEntity));
       return calculatorResponse ;
    }

    @Override
    public List<CalculatorResponseDTO> historyByPAge(Pageable pageable) {

       Page<CalculationEntity>  page =calculatorEntryRepository.findAll(pageable);
        return calculationEntryMapper.toListCalculatorResponse(page.getContent());
    }
}
