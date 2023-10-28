package com.practice.calculator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "operations")
@Getter
@Setter
public class CalculationEntity {

    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="data1")
    private Float data1 ;

    @Column(name="data2")
    private Float data2 ;

    @Column(name="operand")
    private String operand ;

    @Column(name="result")
    private Float result ;

    @CreatedDate
    @Column(name = "execution_time")
    private LocalDateTime execution_time;
    
}
