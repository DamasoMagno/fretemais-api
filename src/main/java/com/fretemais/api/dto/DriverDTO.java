package com.fretemais.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DriverDTO {
    private String fullName;
    private String licenseNumber;
    private LocalDate licenseExpirationDate;
}
