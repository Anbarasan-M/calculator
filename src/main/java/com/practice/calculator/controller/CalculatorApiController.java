package com.practice.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.calculator.dto.CalculatorRequestDTO;
import com.practice.calculator.dto.CalculatorResponseDTO;
import com.practice.calculator.service.CalculatorI;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-16T07:19:53.654363260Z[GMT]")
@RestController
@RequestMapping("/api/v1")
public class CalculatorApiController implements CalculatorApi {

    private static final Logger log = LoggerFactory.getLogger(CalculatorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CalculatorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    @Autowired
    private CalculatorI calculatorI;

    public ResponseEntity<CalculatorResponseDTO> addcalutionReuest(@Parameter(in = ParameterIn.DEFAULT, description = "Inventory item to add", schema=@Schema()) @Valid @RequestBody CalculatorRequestDTO body) {

        CalculatorResponseDTO response = null;

        if (Objects.equals(body.getOperator(), "+") || Objects.equals(body.getOperator(), "-") || Objects.equals(body.getOperator(), "*") || Objects.equals(body.getOperator(), "/")) {
            switch (body.getOperator()) {
                case "-":
                    response =   calculatorI.sub(body);
                    break;
                case "+":
                    response = calculatorI.add(body);
                    break;
                case "*":
                    response = calculatorI.mul(body);
                    break;
                case "/":
                    response = calculatorI.div(body);
                    break;
            }
        }
        else {
            return new ResponseEntity<CalculatorResponseDTO>(HttpStatus.NOT_IMPLEMENTED);
        }
                return new ResponseEntity<CalculatorResponseDTO>(response, HttpStatus.OK);


    }

    public ResponseEntity<List<CalculatorResponseDTO>> searchCalculation() {
        String accept = request.getHeader("Accept");

                return new ResponseEntity<List<CalculatorResponseDTO>>(calculatorI.history(),HttpStatus.OK);


    }

    @Override
    public ResponseEntity<List<CalculatorResponseDTO>> searchCalculationByPageAndSize(String page, String size) {
        Pageable pageable = PageRequest.of(Integer.valueOf(page),Integer.valueOf(size));

        return new ResponseEntity<List<CalculatorResponseDTO>>(calculatorI.historyByPAge(pageable),HttpStatus.OK);
    }


}

