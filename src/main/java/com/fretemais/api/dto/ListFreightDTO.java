package com.fretemais.api.dto;

import com.fretemais.api.domain.Freight;
import com.fretemais.api.domain.Transporter;
import com.fretemais.api.domain.Driver;
import com.fretemais.api.enums.Cargo_Type;
import com.fretemais.api.enums.Freight_Status;
import com.fretemais.api.enums.Payment_Type;
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
public class ListFreightDTO {

    private Long id;
    private Freight_Status status;
    private LocalDate freightDate;
    private Cargo_Type cargoType;
    private Float totalCoast;
    private Vehicle_Type vehicleType;
    private Float totalCost;
    private DriverDTO driver;
    private TransporterDTO transporter;

    public ListFreightDTO(Freight freight) {
        this.id = freight.getId();
        this.status = freight.getStatus();
        this.totalCoast = freight.getTotalCost();
        this.freightDate = freight.getFreightDate();
        this.totalCost = freight.getTotalCost();
        this.cargoType = freight.getCargoType();
        this.vehicleType = freight.getVehicleType();

        if (freight.getTransporter() != null) {
            this.transporter = new TransporterDTO(freight.getTransporter());
        }

        if (freight.getDriver() != null) {
            this.driver = new DriverDTO(freight.getDriver());
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TransporterDTO {
        private Long id;
        private String name;
        private String cnpj;

        public TransporterDTO(Transporter transporter) {
            this.id = transporter.getId();
            this.name = transporter.getName();
            this.cnpj = transporter.getCnpj();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DriverDTO {
        private Long id;
        private String name;

        public DriverDTO(Driver driver) {
            this.id = driver.getId();
            this.name = driver.getFullName();
        }
    }
}
