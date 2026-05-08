package com.example.app.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PirataDto {

    private String name;


    private Double bounty;


    private Double crew;


    private Boolean isActive;
}
