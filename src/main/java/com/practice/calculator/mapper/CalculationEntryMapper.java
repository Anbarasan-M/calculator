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



//    //@Mapping(target = "id",source="id")
//    @Mapping(target = "data1",source="data1")
//    @Mapping(target = "data2",source="data2")
//    @Mapping(target = "operand",source="operand")
//    @Mapping(target = "result",source="result")

    CalculatorResponseDTO toCalculatorResponse(CalculationEntity calculationEntity);

    CalculationEntity toCalculationEntity(CalculatorResponseDTO calculatorResponse);

    List<CalculatorResponseDTO> toListCalculatorResponse(List<CalculationEntity> all);
}
