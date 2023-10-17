package com.practice.calculator.dto;

import java.sql.Timestamp;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


/**
 * CalculatorResponse
 */
@Validated
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CalculatorResponseDTO {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("data1")
  private Float data1;

  @JsonProperty("data2")
  private Float data2 ;

  @JsonProperty("operand")
  private String operand;

  @JsonProperty("result")
  private Float result;

  @JsonProperty("execution_time")
  private Timestamp execution_time;

  public CalculatorResponseDTO id(UUID id) {
    this.id = id;
    return this;
  }


  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }


  @Override
  public int hashCode() {
    return Objects.hash(id, data1, data2, operand, result, execution_time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatorResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    data1: ").append(toIndentedString(data1)).append("\n");
    sb.append("    data2: ").append(toIndentedString(data2)).append("\n");
    sb.append("    operand: ").append(toIndentedString(operand)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
