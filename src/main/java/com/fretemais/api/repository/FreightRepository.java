package com.fretemais.api.repository;

import com.fretemais.api.domain.Freight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreightRepository extends JpaRepository<Freight, Long> {
    List<Freight> findFreightByFreightNumber(String freightNumber);
}
