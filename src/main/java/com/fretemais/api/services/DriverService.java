package com.fretemais.api.services;

import com.fretemais.api.domain.Driver;
import com.fretemais.api.dto.DriverDTO;
import com.fretemais.api.repository.DriverRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> listDrivers(String name){
        if (name != null && !name.isEmpty()) {
            return driverRepository.findByFullNameContainingIgnoreCase(name);
        }
        return driverRepository.findAll();
    }

    public Driver getDriver(Long driverId) {
        return driverRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Transporter not found"));
    }

    public void createDriver(Driver driver) {
        Driver newDriver = new Driver();

        newDriver.setFullName(driver.getFullName());
        newDriver.setLicenseNumber(driver.getLicenseNumber());
        newDriver.setLicenseExpirationDate(driver.getLicenseExpirationDate());

        driverRepository.save(newDriver);
    }

    public void updateDriver(Long driverId, DriverDTO driverDTO) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found"));

        if(driverDTO.getFullName() != null){
            driver.setFullName(driverDTO.getFullName());
        }

        if(driverDTO.getLicenseNumber() != null){
            driver.setLicenseNumber(driverDTO.getLicenseNumber());
        }

        if(driverDTO.getLicenseExpirationDate() != null){
            driver.setLicenseExpirationDate(driverDTO.getLicenseExpirationDate());
        }

        driverRepository.save(driver);
    }

    public void deleteDriver(Long driverId){
        driverRepository.deleteById(driverId);
    }
}
