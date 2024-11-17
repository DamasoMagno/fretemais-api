package com.fretemais.api.dto;

import com.fretemais.api.enums.Cargo_Type;
import com.fretemais.api.enums.Freight_Status;
import com.fretemais.api.enums.Vehicle_Type;
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
    private Freight_Status status;
    private LocalDate freightDate;
    private Cargo_Type cargoType;
    private Vehicle_Type vehicleType;
    private Float totalCost;
    private Long transporter_id;
    private Long driver_id;
}
