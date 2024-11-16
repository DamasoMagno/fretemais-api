package com.fretemais.api.repository;

import com.fretemais.api.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findVehicleByPlateNumber(String platNumber);
}
