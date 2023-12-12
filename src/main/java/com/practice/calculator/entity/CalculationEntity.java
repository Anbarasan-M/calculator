package com.practice.calculator.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Column(name="operator")
    private String operator ;

    @Column(name="result")
    private Float result ;

    @CreatedDate
    @Column(name = "execution_time")
    private LocalDateTime execution_time;
    
}