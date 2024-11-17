package com.fretemais.api.controller;

import com.fretemais.api.domain.Freight;
import com.fretemais.api.dto.FreightDTO;
import com.fretemais.api.dto.ListFreightDTO;
import com.fretemais.api.services.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freight")
public class FreightController {
    @Autowired
    FreightService freightService;

    @GetMapping()
    public ResponseEntity<List<ListFreightDTO>> freights(@RequestParam(required = false) Long freightId) {
        return ResponseEntity.status(HttpStatus.OK).body(freightService.listFreights(freightId));
    }

    @PostMapping()
    public ResponseEntity<?> createFreight(@RequestBody FreightDTO freight) {
        freightService.createFreight(freight);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/{freightId}")
    public ResponseEntity<?> deleteFreight(@PathVariable Long freightId) {
        freightService.deleteFreight(freightId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

     @GetMapping("/{freightId}")
     public ResponseEntity<ListFreightDTO> getFreight(@PathVariable String freightId) {
        return ResponseEntity.status(HttpStatus.OK).body(freightService.getFreight(freightId));
     }

    @PutMapping("/{freightId}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long freightId, @RequestBody FreightDTO freight) {
        freightService.updateFreight(freightId, freight);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
