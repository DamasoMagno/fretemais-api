package com.fretemais.api.services;

import com.fretemais.api.domain.Driver;
import com.fretemais.api.domain.Freight;
import com.fretemais.api.domain.Transporter;
import com.fretemais.api.dto.FreightDTO;
import com.fretemais.api.dto.ListFreightDTO;
import com.fretemais.api.repository.DriverRepository;
import com.fretemais.api.repository.FreightRepository;
import com.fretemais.api.repository.TransporterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FreightService {
    @Autowired
    private FreightRepository freightRepository;
    @Autowired
    private TransporterRepository transporterRepository;
    @Autowired
    private DriverRepository driverRepository;

    public List<ListFreightDTO> listFreights(Long freightId) {
        List<Freight> freights;

        if (freightId != null) {
            System.out.println(freightId);
            freights = freightRepository.findAllById(Collections.singleton(freightId));
        } else {
            freights = freightRepository.findAll();
        }

        return freights.stream()
                .map(ListFreightDTO::new)
                .collect(Collectors.toList());
    }


    public ListFreightDTO getFreight(String freightId) {
        Freight freight = freightRepository.findById(Long.valueOf(freightId)).orElseThrow();
        return new ListFreightDTO(freight);
    }

    public void createFreight(FreightDTO freightDTO) {
        Freight newFreight = new Freight();
        Transporter transporter = transporterRepository.findById(freightDTO.getTransporter_id())
                .orElseThrow(() -> new EntityNotFoundException("Transporter not found"));
        Driver driver = driverRepository.findById(freightDTO.getDriver_id())
                .orElseThrow(() -> new EntityNotFoundException("Driver not found"));

        newFreight.setFreightDate(freightDTO.getFreightDate());
        newFreight.setStatus(freightDTO.getStatus());
        newFreight.setTotalCost(freightDTO.getTotalCost());
        newFreight.setCargoType(freightDTO.getCargoType());
        newFreight.setVehicleType(freightDTO.getVehicleType());
        newFreight.setTotalCost(1200f);

        newFreight.setTransporter(transporter);
        newFreight.setDriver(driver);

        freightRepository.save(newFreight);
    }

    public void updateFreight(Long freightId, FreightDTO freightDTO) {
        Freight freight = freightRepository.findById(freightId)
                .orElseThrow(() -> new EntityNotFoundException("Freight not found"));

        if (freightDTO.getTransporter_id() != null) {
            Transporter transporter = transporterRepository.findById(freightDTO.getTransporter_id())
                    .orElseThrow(() -> new EntityNotFoundException("Transporter not found"));
            freight.setTransporter(transporter);
        }

        if (freightDTO.getDriver_id() != null) {
            Driver driver = driverRepository.findById(freightDTO.getDriver_id())
                    .orElseThrow(() -> new EntityNotFoundException("Driver not found"));
            freight.setDriver(driver);
        }

        if (freightDTO.getFreightDate() != null) {
            freight.setFreightDate(freightDTO.getFreightDate());
        }

        if (freightDTO.getTotalCost() != null) {
            freight.setTotalCost(freightDTO.getTotalCost());
        }

        if (freightDTO.getVehicleType() != null) {
            freight.setVehicleType(freightDTO.getVehicleType());
        }

        if (freightDTO.getStatus() != null) {
            freight.setStatus(freightDTO.getStatus());
        }

        if (freightDTO.getCargoType() != null) {
            freight.setCargoType(freightDTO.getCargoType());
        }

        freightRepository.save(freight);
    }

    public void deleteFreight(Long freightId) {
        freightRepository.deleteById(freightId);
    }
}
