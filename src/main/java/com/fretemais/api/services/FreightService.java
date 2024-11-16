package com.fretemais.api.services;

import com.fretemais.api.domain.Driver;
import com.fretemais.api.domain.Freight;
import com.fretemais.api.domain.Transporter;
import com.fretemais.api.dto.FreightDTO;
import com.fretemais.api.dto.ListFreightDTO;
import com.fretemais.api.enums.Freight_Status;
import com.fretemais.api.repository.DriverRepository;
import com.fretemais.api.repository.FreightRepository;
import com.fretemais.api.repository.TransporterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<ListFreightDTO> listFreights(String freightNumber) {
        List<Freight> freights;

        if (freightNumber != null && !freightNumber.isEmpty()) {
            freights = freightRepository.findFreightByFreightNumber(freightNumber);
        } else {
            freights = freightRepository.findAll();
        }

        return freights.stream()
                .map(ListFreightDTO::new)
                .collect(Collectors.toList());
    }


    public ListFreightDTO getFreight(Long freightId) {
        Freight freight = freightRepository.findById(freightId).orElseThrow();
        return new ListFreightDTO(freight);
    }

    public void createFreight(FreightDTO freightDTO) {
        Freight newFreight = new Freight();
        Transporter transporter = transporterRepository.findById(freightDTO.getTransporter_id())
                .orElseThrow(() -> new EntityNotFoundException("Transporter not found"));
        Driver driver = driverRepository.findById(freightDTO.getDriver_id())
                .orElseThrow(() -> new EntityNotFoundException("Driver not found"));

        newFreight.setFreightNumber(freightDTO.getFreightNumber());
        newFreight.setFreightDate(freightDTO.getFreightDate());
        newFreight.setStatus(Freight_Status.IN_ROUTE);
        newFreight.setDriver(driver);
        newFreight.setTransporter(transporter);

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

        if (freightDTO.getFreightNumber() != null) {
            freight.setFreightNumber(freightDTO.getFreightNumber());
        }

        if (freightDTO.getFreightDate() != null) {
            freight.setFreightDate(freightDTO.getFreightDate());
        }

        if (freightDTO.getStatus() != null) {
            freight.setStatus(freightDTO.getStatus());
        }

        freightRepository.save(freight);
    }

    public void deleteFreight(Long freightId) {
        freightRepository.deleteById(freightId);
    }
}
