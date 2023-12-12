package com.practice.calculator.mapper;

import com.practice.calculator.dto.CalculatorResponseDTO;
import com.practice.calculator.entity.CalculationEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(
        componentModel = "spring",
        imports= UUID.class

)
public interface CalculationEntryMapper {

    CalculatorResponseDTO toCalculatorResponse(CalculationEntity calculationEntity);

    CalculationEntity toCalculationEntity(CalculatorResponseDTO calculatorResponse);

    List<CalculatorResponseDTO> toListCalculatorResponse(List<CalculationEntity> all);
}
