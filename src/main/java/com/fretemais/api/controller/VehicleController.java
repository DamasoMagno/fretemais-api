package com.fretemais.api.controller;

import com.fretemais.api.domain.Vehicle;
import com.fretemais.api.dto.ListVehicleDTO;
import com.fretemais.api.dto.VehicleDTO;
import com.fretemais.api.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping()
    public ResponseEntity<List<ListVehicleDTO>> vehicles(@RequestParam(required = false) String plateNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.listVehicles(plateNumber));
    }

    @PostMapping()
    public ResponseEntity<Void> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.createVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<?> deleteFreight(@PathVariable Long vehicleId) {
      vehicleService.deleteVehicle(vehicleId);
      return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<?> getFreight(@PathVariable Long vehicleId) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicle(vehicleId));
     }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<?> updatePerson(@PathVariable Long vehicleId, @RequestBody VehicleDTO vehicle) {
        vehicleService.updateVehicle(vehicleId, vehicle);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
