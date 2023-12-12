package com.practice.calculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


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

  @JsonProperty("operator")
  private String operator;

  @JsonProperty("result")
  private Float result;

  @JsonProperty("execution_time")
  private LocalDateTime execution_time;

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
    return Objects.hash(id, data1, data2, operator, result, execution_time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatorResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    data1: ").append(toIndentedString(data1)).append("\n");
    sb.append("    data2: ").append(toIndentedString(data2)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
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
