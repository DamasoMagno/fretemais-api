package com.fretemais.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fretemais.api.enums.Cargo_Type;
import com.fretemais.api.enums.Freight_Status;
import com.fretemais.api.enums.Vehicle_Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "freight")
public class Freight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Alterado de Long para String

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Freight_Status status;

    @Column(nullable = false, name = "freight_date")
    private LocalDate freightDate;

    @ManyToOne
    @JoinColumn(name = "transporter_id", nullable = false)
    @JsonIgnore
    private Transporter transporter;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    @JsonIgnore
    private Driver driver;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", nullable = false)
    private Vehicle_Type vehicleType;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo_type", nullable = false)
    private Cargo_Type cargoType;

    @Column(nullable = true)
    private Float totalCost;
}
