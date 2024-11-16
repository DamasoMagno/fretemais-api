package com.fretemais.api.services;

import com.fretemais.api.domain.Transporter;
import com.fretemais.api.domain.Vehicle;
import com.fretemais.api.dto.ListVehicleDTO;
import com.fretemais.api.dto.VehicleDTO;
import com.fretemais.api.repository.TransporterRepository;
import com.fretemais.api.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    private TransporterRepository transporterRepository;

    public List<ListVehicleDTO> listVehicles(String plateNumber) {
        List<Vehicle> vehicles;

        if(plateNumber != null && !plateNumber.isEmpty()){
            vehicles = vehicleRepository.findVehicleByPlateNumber(plateNumber);
        } else {
           vehicles = vehicleRepository.findAll();
        }

        return vehicles.stream()
                .map(ListVehicleDTO::new)
                .collect(Collectors.toList());
    }

    public ListVehicleDTO getVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow();
        return new ListVehicleDTO(vehicle);
    }

    public void createVehicle(VehicleDTO vehicle) {
        Vehicle newVehicle = new Vehicle();

        Transporter transporter = transporterRepository.findById(vehicle.getTransporter_id())
                .orElseThrow(() -> new EntityNotFoundException("Transporter not found"));

        newVehicle.setPlateNumber(vehicle.getPlateNumber());
        newVehicle.setVehicleType(vehicle.getVehicleType());
        newVehicle.setTransporter(transporter);

        vehicleRepository.save(newVehicle);
    }

    public void updateVehicle(Long vehicleId, VehicleDTO vehicle) {
        Vehicle updateVehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        if(vehicle.getVehicleType() != null) {
            updateVehicle.setVehicleType(vehicle.getVehicleType());
        }

        if(vehicle.getTransporter_id() != null) {
            Transporter transporter = transporterRepository.findById(vehicle.getTransporter_id())
                    .orElseThrow(() -> new EntityNotFoundException("Transporter not found"));

            updateVehicle.setTransporter(transporter);
        }

        if(vehicle.getPlateNumber() != null) {
            updateVehicle.setPlateNumber(vehicle.getPlateNumber());
        }

        vehicleRepository.save(updateVehicle);
    }

    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}
