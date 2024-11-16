package com.fretemais.api.controller;

import com.fretemais.api.domain.Driver;
import com.fretemais.api.dto.DriverDTO;
import com.fretemais.api.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<Driver> listDrivers(@RequestParam(required = false) String driverName) {
        return driverService.listDrivers(driverName);
    }

    @PostMapping()
    public ResponseEntity<Void> createDriver(@RequestBody Driver driver) {
        driverService.createDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long driverId) {
        driverService.deleteDriver(driverId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<Driver> getDriver(@PathVariable Long driverId) {
      return ResponseEntity.status(HttpStatus.OK).body(driverService.getDriver(driverId));
    }

    @PutMapping("/{driverId}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long driverId, @RequestBody DriverDTO driver) {
        driverService.updateDriver(driverId, driver);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
