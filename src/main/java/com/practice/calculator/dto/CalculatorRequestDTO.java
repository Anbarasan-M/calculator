package com.practice.calculator.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


/**
 * CalculatorRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-16T07:19:53.654363260Z[GMT]")

@Getter
@Setter

public class CalculatorRequestDTO {
  @JsonProperty("data1")
  private Float data1 = null;

  @JsonProperty("data2")
  private Float data2 = null;

  @JsonProperty("operand")
  private String operand = null;

  @Override
  public int hashCode() {
    return Objects.hash(data1, data2, operand);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatorRequest {\n");
    
    sb.append("    data1: ").append(toIndentedString(data1)).append("\n");
    sb.append("    data2: ").append(toIndentedString(data2)).append("\n");
    sb.append("    operand: ").append(toIndentedString(operand)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
