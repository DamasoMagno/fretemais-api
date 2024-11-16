package com.fretemais.api.services;

import com.fretemais.api.domain.Transporter;
import com.fretemais.api.dto.TransporterDTO;
import com.fretemais.api.repository.DriverRepository;
import com.fretemais.api.repository.TransporterRepository;
import com.fretemais.api.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransporterService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    TransporterRepository transporterRepository;

    public List<Transporter> listTransporters(String name){
        if(name != null && !name.isEmpty()){
            return transporterRepository.findTransportersByNameContainingIgnoreCase(name);
        }

        return transporterRepository.findAll();
    }

    public Transporter getTransporter(Long transporterId) {
        return transporterRepository.findById(transporterId)
                .orElseThrow(() -> new EntityNotFoundException("Transporter not found"));
    }

    public void createTransporter(Transporter transporter) {
        Transporter newTransporter = new Transporter();

        newTransporter.setName(transporter.getName());
        newTransporter.setCnpj(transporter.getCnpj());

        transporterRepository.save(newTransporter);
    }

    public void updateTransporter(Long transporterId, TransporterDTO transporterDTO) {
        Transporter transporter = transporterRepository.findById(transporterId)
                .orElseThrow(() -> new EntityNotFoundException("Transporter not found"));

        if(transporterDTO.getName() != null){
            transporter.setName(transporterDTO.getName());
        }

        if(transporterDTO.getCnpj() != null){
            transporter.setCnpj(transporterDTO.getCnpj());
        }

        transporterRepository.save(transporter);
    }

    public void deleteTransporter(Long transporterId) {
        transporterRepository.deleteById(transporterId);
    }
}
