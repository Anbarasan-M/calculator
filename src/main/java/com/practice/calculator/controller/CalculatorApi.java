/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.practice.calculator.controller;

import com.practice.calculator.dto.CalculatorRequestDTO;
import com.practice.calculator.dto.CalculatorResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-16T07:19:53.654363260Z[GMT]")
@Validated
public interface CalculatorApi {

    @Operation(summary = "adds an calculation item", description = "Adds an calulation request to the system", tags={ "developers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "response of requested calculation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorResponseDTO.class))),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),
        
        @ApiResponse(responseCode = "409", description = "an existing item already exists") })
    @RequestMapping(value = "/calculator",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<CalculatorResponseDTO> addcalutionReuest(@Parameter(in = ParameterIn.DEFAULT, description = "Inventory item to add", schema=@Schema()) @Valid @RequestBody CalculatorRequestDTO body);


    @Operation(summary = "searches calculations", description = "By passing in the appropriate options, you can search for available inventory in the system ", tags={ "developers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CalculatorResponseDTO.class)))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    @RequestMapping(value = "/calculator",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<CalculatorResponseDTO>> searchCalculation();
    @Operation(summary = "searches calculations", description = "By passing in the appropriate options, you can search for available inventory in the system ", tags={ "developers" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CalculatorResponseDTO.class)))),

            @ApiResponse(responseCode = "400", description = "bad input parameter") })
    @RequestMapping(value = "/calculator/page",
            produces = { "application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<CalculatorResponseDTO>> searchCalculationByPageAndSize(@RequestParam("page") String page,@RequestParam("size") String size);



}

