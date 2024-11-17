package com.fretemais.api.dto;

import com.fretemais.api.domain.Transporter;
import com.fretemais.api.domain.Vehicle;
import com.fretemais.api.enums.Vehicle_Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListVehicleDTO {
    private Long id;
    private String plateNumber;
    private Vehicle_Type vehicleType;
    private TransporterDTO transporter;

    public ListVehicleDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.plateNumber = vehicle.getPlateNumber();
        this.vehicleType = vehicle.getVehicleType();

        if (vehicle.getTransporter() != null) {
            this.transporter = new TransporterDTO(vehicle.getTransporter());
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TransporterDTO {
        private Long id;
        private String name;  // Exemplo de campo da transportadora
        private String cnpj;

        public TransporterDTO(Transporter transporter) {
            this.id = transporter.getId();
            this.name = transporter.getName();// Apenas o nome ou outros campos relevantes
            this.cnpj = transporter.getCnpj();
        }
    }
}