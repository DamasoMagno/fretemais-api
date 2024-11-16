package com.fretemais.api.repository;

import com.fretemais.api.domain.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransporterRepository extends JpaRepository<Transporter, Long> {
    List<Transporter> findTransportersByNameContainingIgnoreCase(String name);
}
