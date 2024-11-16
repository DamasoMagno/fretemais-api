package com.fretemais.api.dto;

import com.fretemais.api.enums.Freight_Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FreightDTO {
    private String freightNumber;
    private Freight_Status status;
    private LocalDate freightDate;
    private Long transporter_id;
    private Long driver_id;
}
