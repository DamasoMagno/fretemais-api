package com.fretemais.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fretemais.api.enums.Freight_Status;
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
    private Long id;

    @Column(nullable = false, unique = true)
    private String freightNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Freight_Status status;

    @Column(nullable = false)
    private LocalDate freightDate;

    @ManyToOne
    @JoinColumn(name = "transporter_id", nullable = false)
    @JsonIgnore
    private Transporter transporter;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    @JsonIgnore
    private Driver driver;
}
