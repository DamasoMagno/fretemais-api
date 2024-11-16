package com.fretemais.api.dto;

import com.fretemais.api.enums.Vehicle_Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VehicleDTO {
    private String plateNumber;
    private Vehicle_Type vehicleType;
    private Long transporter_id;
}
