package com.fretemais.api.repository;

import com.fretemais.api.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByFullNameContainingIgnoreCase(String name);
}
