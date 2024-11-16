package com.fretemais.api.dto;

import com.fretemais.api.domain.Freight;
import com.fretemais.api.domain.Transporter;
import com.fretemais.api.domain.Driver;
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
public class ListFreightDTO {

    private Long id;
    private String freightNumber;
    private Freight_Status status;
    private LocalDate freightDate;
    private TransporterDTO transporter;
    private DriverDTO driver;  // Novo campo para o motorista

    // Construtor que recebe um objeto Freight e mapeia para o DTO
    public ListFreightDTO(Freight freight) {
        this.id = freight.getId();
        this.freightNumber = freight.getFreightNumber();
        this.status = freight.getStatus();
        this.freightDate = freight.getFreightDate();

        // Mapear a transportadora, se presente
        if (freight.getTransporter() != null) {
            this.transporter = new TransporterDTO(freight.getTransporter());
        }

        // Mapear o motorista, se presente
        if (freight.getDriver() != null) {
            this.driver = new DriverDTO(freight.getDriver());
        }
    }

    // DTO para transportadora, incluindo apenas os campos necessários
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TransporterDTO {
        private Long id;
        private String name;  // Nome da transportadora
        private String cnpj;  // CNPJ da transportadora

        // Construtor para mapear a transportadora
        public TransporterDTO(Transporter transporter) {
            this.id = transporter.getId();
            this.name = transporter.getName();
            this.cnpj = transporter.getCnpj();
        }
    }

    // DTO para motorista (driver), incluindo apenas os campos necessários
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DriverDTO {
        private Long id;
        private String name;  // Nome do motorista

        // Construtor para mapear o motorista
        public DriverDTO(Driver driver) {
            this.id = driver.getId();
            this.name = driver.getFullName();
        }
    }
}
